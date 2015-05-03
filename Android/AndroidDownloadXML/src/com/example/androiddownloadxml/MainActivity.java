package com.example.androiddownloadxml;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//botoia eskuratu
		View boton = findViewById(R.id.botoia);
		//botoia erregistratu Listener-en
		boton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		TextView testua = (TextView) findViewById(R.id.testu_kaxa);
		
		DownloadXML.getXMLfromURL("http://api.openstreetmap.org/api/0.6/map?bbox=-1.7909875049949238,43.33711727928965,-1.786695970571267,43.338873015822415");
		
		testua.setText("kaixo");
	}

}
