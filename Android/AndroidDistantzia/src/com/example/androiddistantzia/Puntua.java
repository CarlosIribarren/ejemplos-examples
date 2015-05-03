package com.example.androiddistantzia;

public class Puntua {
	private Double lat;
	private Double lon;
	
	public Puntua()
	{
		
	}
	
	public Puntua( Double latitudea, Double longitudea)
	{
		latitudea = lat;
		longitudea = lon;
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
