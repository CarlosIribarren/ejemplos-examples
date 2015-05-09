package com.example.androidtts_otherclass;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;

public class Sintetizatzailea implements TextToSpeech.OnInitListener {

	//TextToSpeech aldagaia
	private TextToSpeech textToSpeech;
	
	public Sintetizatzailea(Context context)
	{
		textToSpeech = new TextToSpeech(context,this);
	}
	
	
	@Override
	public void onInit(int arg0) {
		//sintetizatzailea ondo kargatu bada, 
		//lerro hau garrantzitsua da
	    if (arg0 == TextToSpeech.SUCCESS) {
	    	//sintetizatzailea konfiguratu
    		textToSpeech.setLanguage( new Locale( "spa", "ESP" ) );
            textToSpeech.setSpeechRate( 0.0f );
            textToSpeech.setPitch( 0.0f );
            //Erabiltzaileari Agurra
	    	textToSpeech.speak("hola", TextToSpeech.QUEUE_FLUSH, null);
	    }
		
	}
	//Sintetizatzailea testua->ahotsa , Hizkuntza=Gaztelera
    public void speak( String str )
    {
            textToSpeech.speak( str, TextToSpeech.QUEUE_FLUSH, null );
    }	
    public void stopTTS(){
        if(textToSpeech != null){
        	textToSpeech.shutdown();
        	textToSpeech.stop();
        	textToSpeech = null;
        }
    }
	//Denbora mezua esateko/entzuteko
	 public void speakBukatzekoDenbora()
	 { 
		//Iterazioa hitzegiten bukatu harte 
	    while(textToSpeech.isSpeaking()==true)
	    {
	    }
	 }
	 public void hizkuntzaEzarri(Locale locale)
	 {
		 textToSpeech.setLanguage(locale);
	 }

}
