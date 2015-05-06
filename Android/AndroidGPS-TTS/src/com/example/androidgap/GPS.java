package com.example.androidgap;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPS {
	
	private Double lat ;
	private Double lon;
	
	public GPS(Object obj){
		
		lat=0.0;
		lon=0.0;
		
		//configuratu GPS
		LocationManager  mLocationManager;
		LocationListener mLocationListener;
		
		mLocationManager = (LocationManager)  obj;
		mLocationListener = new MyLocationListener();
		
		mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 1, mLocationListener);
		
		
	}
	
	private class MyLocationListener implements LocationListener
	{

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			lat=  location.getLatitude();
			lon= location.getLongitude();
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	
	

}
