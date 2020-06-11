package oiasso.systems.junit.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;


public class PropertyUtils {
	
	/**
	 * Constructor privado para asegurarnos que nadie puede instancias la clase.
	 * @throws InstantiationException
	 */
	private PropertyUtils() throws InstantiationException
	{
	    throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	/**
	 * Get the list of HttpHost from list of URLs in String format.
	 * 
	 * @param urls List of URLs in String format.
	 * @return List of HttpHost objects.
	 */
	public static List<HttpHost> getHttpHostList(final List<String> urls){
		
		final List<HttpHost> result = new ArrayList<>();

		if(urls == null) {
			return result;
		}
		
		for (String url : urls) {
			// Remove '/' character
			url = url.replaceAll("/", "");
			// Separate http_method, ip / host and port from a URL
			final String[] parts = url.split(":");
			// Verify URL
			if(parts.length!=3) {
				throw new IllegalArgumentException("URL is no good formed. Need to [HTTP_METHOD]://[IP_HOST]:[PORT]");
			}
			// Add new HttpHost
			result.add(new HttpHost(parts[1], Integer.valueOf(parts[2]), parts[0]));
		}
		
		return result;
	}
	
}
