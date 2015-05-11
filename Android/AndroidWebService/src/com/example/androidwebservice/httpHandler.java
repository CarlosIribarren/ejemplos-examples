package com.example.androidwebservice;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class httpHandler {
	
	public String get(String posturl){
		try{
			HttpClient httpclient = new DefaultHttpClient();
			//HttpPost httppost = new HttpPost(posturl);
			HttpGet httpget = new HttpGet(posturl);
			
			HttpResponse res = httpclient.execute(httpget);
			HttpEntity ent = res.getEntity();
			
			String text = EntityUtils.toString(ent);
			 //text = "kaixo2";
			
			
			/*
			   String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><a><b></b><c></c></a>";  

			    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
			    DocumentBuilder builder;  
			    try  
			    {  
			        builder = factory.newDocumentBuilder();  
			        Document document = builder.parse( new InputSource( new StringReader( text ) ) );  
			    } catch (Exception e) {  
			        e.printStackTrace();  
			    } 
			*/
			
			
			return text;
			
		}catch(Exception e){
			return e.toString();
		}
		
		
		
	}

}
