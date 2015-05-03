package com.example.androiddownloadxml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Environment;

public class DownloadXML {
	
	//clase para descargar un fichero XML con REST
	
	public static String getXMLfromURL(String url)
	{
		HttpURLConnection conexion;
		URL nereURL;
		
		InputStream entrada;
		//Archivo xml
		File xml;
		//flujo de salida que permite escribir en el archivo xml
		FileOutputStream fileOut;
		
		
		//8kB = 1024 X 8
		final int bufferSize= 1024;
		byte[] buffer;
		try{
			nereURL = new URL(url);
			conexion = (HttpURLConnection) nereURL.openConnection();
			//timeoutMillis
			conexion.setReadTimeout(10000000);
			conexion.setConnectTimeout(10000000);
			conexion.setDoInput(true);
			conexion.setRequestMethod("GET");
			conexion.connect();
			
			entrada = conexion.getInputStream();
			
			xml = new File(Environment.getExternalStorageDirectory().toString() + "/karlos.xml");
			fileOut = new FileOutputStream(xml);
			
			int bytesAescribir;
			//crear buffer
			buffer= new byte[bufferSize];
			//leer entrada con el buffer
			while((bytesAescribir= entrada.read(buffer))>0)
			{
				//escribir en el archivo ( ,  ,) 
				fileOut.write(buffer,0,bytesAescribir);
			}
			
			entrada.close();
			fileOut.close();
			conexion.disconnect();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return url;
	}
	
	

}
