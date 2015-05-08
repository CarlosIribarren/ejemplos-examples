package com.example.androidpoligonoak;

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
		
		Polygon polygon = Polygon.Builder()
		        .addVertex(new Point(1, 3))
		        .addVertex(new Point(2, 8))
		        .addVertex(new Point(5, 4))
		        .addVertex(new Point(5, 9))
		        .addVertex(new Point(7, 5))
		        .addVertex(new Point(6, 1))
		        .addVertex(new Point(3, 1))
		        .build();
		
		
		// // Point is inside
		Point pointA = new Point(5, 7);		
		// Point isn't inside
		Point pointB = new Point(4, 7);
		
		boolean contains = polygon.contains(pointB);
		
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
