package com.example.androidtts_otherclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener  {

	private Button botoia;
	private Sintetizatzailea nereSintetizatzailea;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		botoia = (Button) findViewById(R.id.botoia);
		botoia.setOnClickListener(this);
		
		//Sintetizatzailea aldagaia sortu
		nereSintetizatzailea = new Sintetizatzailea(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		nereSintetizatzailea.speak("kaixo");
		
	}


	


}
