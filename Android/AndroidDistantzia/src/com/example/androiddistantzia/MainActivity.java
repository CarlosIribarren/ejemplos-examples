package com.example.androiddistantzia;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TextView testua = (TextView) findViewById(R.id.testua);
		
		Puntua p1 = new Puntua();
		p1.setLat(43.3378512);
		p1.setLon(-1.7890937);
		Puntua p2 = new Puntua();
		p2.setLat(43.3382962);
		p2.setLon(-1.7892133);
		Double distantzia = this.getDistance(p1, p2);
		testua.setText(distantzia.toString());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
    public static double getDistance(Puntua p1, Puntua p2) {
    	
    	final double EARTH_DIAMETER = 6371.01 * 1000; //meters

    	Double lagp1Lon = p1.getLon() ;
    	Double lagp2Lon = p2.getLon();
        Double diffLongitudes0 = lagp2Lon - lagp1Lon ;
        double diffLongitudes = Math.toRadians(diffLongitudes0);
        double slat = Math.toRadians(p1.getLat());
        double flat = Math.toRadians(p2.getLat());

        //spherical law of cosines
        double c = Math.acos((Math.sin(slat) * Math.sin(flat)) + (Math.cos(slat) * Math.cos(flat) * Math.cos(diffLongitudes)));

        //Vincenty formula
// double c = sqrt(pow(cos(flat) * sin(diffLongitudes), 2d) + pow(cos(slat) * sin(flat) - sin(slat) * cos(flat) * cos(diffLongitudes), 2d));
// c = c / (sin(slat) * sin(flat) + cos(slat) * cos(flat) * cos(diffLongitudes));
// c = atan(c);

        return EARTH_DIAMETER * c;
    }
	
	
}
