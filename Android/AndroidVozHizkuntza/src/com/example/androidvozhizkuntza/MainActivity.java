package com.example.androidvozhizkuntza;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.speech.RecognizerIntent;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	 private static final int VOICE_RECOGNITION_REQUEST_CODE = 1;
	 private Button bt_start;
	 private TextView text_testua;
	 private Vector<String> nombres;
	 private Vector<String> telefonos;

	 @Override 
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);
	  //Relacionamos el boton con el XML 
	  bt_start = (Button)findViewById(R.id.button1);  
	  text_testua = (TextView) findViewById(R.id.testua);
	  bt_start.setOnClickListener(new OnClickListener() {
	   public void onClick(View v) {
	    //Lanzamos el reconoimiento de voz
	    startVoiceRecognitionActivity();
	   }
	  });
	  //Recogemos todos los telefonos y nombre en los
	  //vetores: nombres y telefonos
	  //getNameNumber();
	 }
	 
	 
	 private void startVoiceRecognitionActivity() {
	  // Definición del intent para realizar en análisis del mensaje
	  Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
	  // Indicamos el modelo de lenguaje para el intent
	  intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
	    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
	  // Definimos el mensaje que aparecerá 
	  intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Diga, Llamar a ...");
	  // Lanzamos la actividad esperando resultados
	  startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
	 }
	 
	 @Override
	 //Recogemos los resultados del reconocimiento de voz
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  //Si el reconocimiento a sido bueno
	  if(requestCode == VOICE_RECOGNITION_REQUEST_CODE && resultCode == RESULT_OK){
	  //El intent nos envia un ArrayList aunque en este caso solo 
	   //utilizaremos la pos.0
	    ArrayList<String> matches = data.getStringArrayListExtra
	      (RecognizerIntent.EXTRA_RESULTS);
	    //Separo el texto en palabras.
	    String [ ] palabras = matches.get(0).toString().split(" ");
	    text_testua.setText(matches.toString());
	    //Toast.makeText(this,matches.toString() , Toast.LENGTH_LONG).show();
	    
	    
	    String laguntza_katea =getString(R.string.laguntza);

	    	if ( matches.indexOf(laguntza_katea)!=-1)
	    	{
	    		Resources res = this.getResources();
	    		DisplayMetrics dm = res.getDisplayMetrics();
	    		android.content.res.Configuration conf = res.getConfiguration();
	    		conf.locale = new Locale("en");
	    		res.updateConfiguration(conf, dm);
	    		finish();startActivity(getIntent());
	    		
	    		Toast.makeText(this,"Hizkuntza Inglesa jarri da!!!" , Toast.LENGTH_LONG).show();
	    		
	    		//text_testua.setText("Hizkuntza Inglesa jarri da!!!");
	    	}
	    	

	    
	    
	    /*
	    //Si la primera palabra es LLAMAR
	    if(palabras[0].contains("hola"))
	    {
	    	//Toast.makeText(this,"AYUDA CONSEGUIDOOOOOOO" , Toast.LENGTH_LONG).show();
	    	text_testua.setText("AYUDA CONSEGUIDOOOOOOO");
	    	
	    
	    for(int a=0;a<nombres.size();a++)
	    {
	    //Busco el nombre que es la tercera posicion (LLAMAR A LORENA)
	    if(nombres.get(a).equals(palabras[2]))
	    {
	    //Si la encuentra recojo el numero telf en el otro
	    //vector que coincidira con la posicion ya que
	    //los hemos rellenado a la vez.
	    Intent callIntent = new Intent(Intent.ACTION_CALL);
	    callIntent.setData(Uri.parse("tel:"+telefonos.get(a)));
	    //Realizo la llamada
	    startActivity(callIntent);
	    break;
	    }
	    }
	    
	    }
	    */
	  }
	  else
	  {
		  text_testua.setText("no se a encontrado nadaaaaa");
		  
	  }
	 }
	 
	 /*
	 //Con el getNameNumber lo que hago es recoger los nombres 
	 //de la SIM en un vector
	 //Y los numeros de telefonos en otro vector, eso sí tienen que coincidir
	 //las posiciones de uno y de otro, por eso los relleno a la vez.
	 private void getNameNumber(){ 
	 nombres = new Vector<String>();
	 telefonos = new Vector<String>(); 
	        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
	        ContentResolver cr = getContentResolver();
	        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
	       null, null, null, null);
	        String[] projection = new String[] {
	       ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
	              ContactsContract.CommonDataKinds.Phone.NUMBER };
	        Cursor names = getContentResolver().query(
	       uri, projection, null, null, null);
	        int indexName = names.getColumnIndex(
	       ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
	        int indexNumber = names.getColumnIndex(
	       ContactsContract.CommonDataKinds.Phone.NUMBER);
	        names.moveToFirst();
	        do {
	           //Aquí relleno los dos
	           String name   = names.getString(indexName);
	           nombres.add(name);
	           String number = names.getString(indexNumber);
	           telefonos.add(number);
	        } while (names.moveToNext());
	    }
	    */
	}
