package com.example.androidpoligonoak2;

import java.util.LinkedList;

import com.example.androidpoligonoak2.Point;
import com.example.androidpoligonoak2.Polygon;
import com.example.androidpoligonoak2.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView testua;

		testua = (TextView) findViewById(R.id.testua);
		/*
		Polygon polygon = Polygon.Builder()
		        .addVertex(new Point( 43.3076802f, -2.0107721f))
		        .addVertex(new Point( 43.3062768f, -2.0094659f))
		        .addVertex(new Point( 43.3065521f, -2.0089294f))
		        .addVertex(new Point( 43.3070214f, -2.009354f))
		        .addVertex(new Point( 43.3070501f, -2.0094761f))
		        .addVertex(new Point( 43.3079366f, -2.0102342f))
		        
		        .addVertex(new Point(43.3076802f, -2.0107721f))
		        .build();
		
		*/
		
		LinkedList<Point> puntuZerrenda = new LinkedList<Point>();
		Point puntua1 = new Point( 43.3076802f, -2.0107721f);
		Point puntua2 = new Point( 43.3062768f, -2.0094659f);
		Point puntua3 = new Point( 43.3065521f, -2.0089294f);
		Point puntua4 = new Point( 43.3070214f, -2.009354f);
		Point puntua5 = new Point( 43.3070501f, -2.0094761f);
		Point puntua6 = new Point( 43.3079366f, -2.0102342f);
		Point puntua7 = new Point( 43.3076802f, -2.0107721f);
		
		puntuZerrenda.add(puntua1);
		puntuZerrenda.add(puntua2);
		puntuZerrenda.add(puntua3);
		puntuZerrenda.add(puntua4);
		puntuZerrenda.add(puntua5);
		puntuZerrenda.add(puntua6);
		puntuZerrenda.add(puntua7);
		
		Polygon poligonoa = Polygon.Builder()
					.sortuPoligonoa(puntuZerrenda);
		
		
		// // Point BARRUAN
		Point pointA = new Point(43.307032f, -2.0098286f);		
		
		// // Point KANPOAN
		Point pointB = new Point(43.3082475f, -2.0101853f);	
		
		boolean contains = poligonoa.contains(pointA);
		
		if(contains==true)
		{
			testua.setText("true");
		}
		else
		{
			testua.setText("false");
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
