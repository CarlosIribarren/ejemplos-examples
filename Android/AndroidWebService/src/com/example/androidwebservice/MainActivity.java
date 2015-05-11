package com.example.androidwebservice;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Web-Zerbitzua
		httpHandler handler = new httpHandler();
		String url2= "http://services.gisgraphy.com/street/search?lat=43,3409812&lng=-1,7923606&from=1&to=1";
		// url2="http://api.openstreetmap.org/api/0.6/map?bbox=-1.78922,43.33783,-1.78859,43.33833";
		String txt = handler.get(url2);
		
		TextView t = (TextView) findViewById(R.id.testua);
		//TextView scroll jarri
		t.setMovementMethod(new ScrollingMovementMethod());
		t.setText(txt);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
