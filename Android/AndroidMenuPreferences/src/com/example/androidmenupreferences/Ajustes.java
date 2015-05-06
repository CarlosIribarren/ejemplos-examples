package com.example.androidmenupreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Ajustes extends Activity {
		
	Button botoiaAtera; 
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.ajustes);
			
			
			botoiaAtera = (Button) findViewById(R.id.botoiaAtera);
			botoiaAtera.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
		
					//ajustes pantaila itxi
					finish();
				}
			});
			
		}
}
