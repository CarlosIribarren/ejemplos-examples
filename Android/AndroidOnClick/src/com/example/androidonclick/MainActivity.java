package com.example.androidonclick;

import java.util.Locale;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;

public class MainActivity extends Activity implements OnClickListener,TextToSpeech.OnInitListener {

	//TextToSpeech aldagaia
	private TextToSpeech textToSpeech;
	
	GPS nereGPS;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//TextToSpeech aldagaia sortu
		textToSpeech = new TextToSpeech( this, this );
		//botoia eskuratu
		View boton = findViewById(R.id.botoia);
		//botoia erregistratu Listener-en
		boton.setOnClickListener(this);
		//GPS aldagaia erazagutu
		nereGPS = new GPS(getSystemService(Context.LOCATION_SERVICE));
		
	}

	//Botoian Click-egin
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//begiratu ea botoia den
		if (v.getId()==findViewById(R.id.botoia).getId())
		{
			//botoia erreferentziatu, ez da sortzen
			TextView testo = (TextView) findViewById(R.id.testua);
			String katea= "Botoian click egin duzu";
			
			String katea2 = nereGPS.getLat().toString();
			
			testo.setText(katea2);
			this.speak(katea2);
		}
		
	}

	//called when TextToSpeech engine Initialization
	@Override
	public void onInit(int status) {
		// TODO Auto-generated method stub
        if ( status == TextToSpeech.LANG_MISSING_DATA | status == TextToSpeech.LANG_NOT_SUPPORTED )
        {
                Toast.makeText( this, "ERROR LANG_MISSING_DATA | LANG_NOT_SUPPORTED", Toast.LENGTH_SHORT ).show();
        }
	}

	//called when activity is Destroyed
    @Override
    protected void onDestroy()
    {
            if ( textToSpeech != null )
            {
                    textToSpeech.stop();
                    textToSpeech.shutdown();
            }
            super.onDestroy();
    }

    //Sintetizatzailea testua->ahotsa , Hizkuntza=Gaztelera
    private void speak( String str )
    {
    		textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
            textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
            textToSpeech.setSpeechRate( 0.0f );
            textToSpeech.setPitch( 0.0f );
    }
}
