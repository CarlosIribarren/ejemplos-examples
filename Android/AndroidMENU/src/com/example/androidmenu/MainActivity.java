package com.example.androidmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.ajustes:
			Toast.makeText(this, "ajustes", Toast.LENGTH_LONG).show();
			return true;
		case R.id.ayuda:
			Toast.makeText(this, "ayuda", Toast.LENGTH_LONG).show();
			return true;	
		case R.id.salir:
			finish();
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

	
	
}
