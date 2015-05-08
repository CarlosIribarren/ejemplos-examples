package com.example.androidmugitukordenatua;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Double lon_lag,lat_lag;
		lat_lag=-43.3409812;
		lon_lag=1.7923606;
		
		Point hasiera = new Point();
		hasiera.setLat(lat_lag);
		hasiera.setLon(lon_lag);
		
		Double distantzia = 0.0000001;
		
		Integer angelua = 0;
		
		Point erantzuna = new Point();
		erantzuna = this.kordenatuakMugitu(hasiera, distantzia, angelua);
		
		TextView testuKaxa = (TextView) findViewById(R.id.testua);
		testuKaxa.setText("erantzuna lat : " + erantzuna.getLat().toString() + "  Lon : " + erantzuna.getLon().toString());
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public Point kordenatuakMugitu(Point jatorria, Double distantzia, Integer angelua)
	{
		//-----------------------------------------------------------------
		// jatorria = hasierako puntua da
		// distantzia = neurria
		// angelua = norabidea
		// 
		// P = ( a , b ) + L( @x , @b )
		// Point = jatorria + distantzia*(sin(angelua),cos(angelua))
		//-----------------------------------------------------------------
		
		//erantzuna prestatu
		Point kordenatuak = new Point();
		
		//Graduak -> Radianak
		// R = ( Angelua * 2.0 * PI ) / 360
		Double z1 = this.bider2zenbaki(Double.parseDouble(angelua.toString()), 2.0);
		Double z2 = this.bider2zenbaki(z1, Math.PI);
		Double z3AngeluaRadianetan = this.zati2zenbaki(z2, 360.0);
		
		//sin(angelua) eta cos(angelua) lortu
		Double sinAngelua = Math.sin(z3AngeluaRadianetan);
		Double cosAngelua = Math.cos(z3AngeluaRadianetan);
		
		//sin eta cos formateatu => ####.#######
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		DecimalFormat formateador = new DecimalFormat("####.#######",simbolos);
		String sin = formateador.format (sinAngelua);
		String cos = formateador.format (cosAngelua);
		
		//Biderkaketarako prestatu
		Double angeluaSinDouble = Double.parseDouble(sin);
		Double angeluaCosDouble = Double.parseDouble(cos);
		
		//lortu tarteko puntua 
		//distantzia*(sin(angelua),cos(angelua))
		Double tartekoLat = this.bider2zenbaki(distantzia, angeluaCosDouble);
		Double tartekoLon = this.bider2zenbaki(distantzia, angeluaSinDouble);
		
		//gehitu jatorriari tarteko puntua 
		//Point = jatorria + desplazamendua
		Double lat = this.gehitu2zenbaki(jatorria.getLat(), tartekoLat);
		Double lon = this.gehitu2zenbaki(jatorria.getLon(), tartekoLon);
		
		//Puntu berria bueltan 
		kordenatuak.setLat(lat);
		kordenatuak.setLon(lon);
		return kordenatuak;
	}
	public double gehitu2zenbaki(Double z1,Double z2)
	{
		BigDecimal d1 = new BigDecimal(z1.toString());
		BigDecimal d2 = new BigDecimal(z2.toString());
		//batura 
		d2 = d2.add(d1);
		return Double.parseDouble(d2.toString()); 
	}
	public double bider2zenbaki(Double z1,Double z2)
	{
		BigDecimal d1 = new BigDecimal(z1.toString());
		BigDecimal d2 = new BigDecimal(z2.toString());
		//bider
		d2 = d2.multiply(d1);
		return Double.parseDouble(d2.toString()); 
	}	
	public double zati2zenbaki(Double z1,Double z2)
	{
		return  z1 / z2;
	}		
	
	
}
