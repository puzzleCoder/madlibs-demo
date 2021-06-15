package io.pantheon.interview.question.madlibsdemo.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MadlibsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MadlibsService.class);
	
	private String baseUrl = "https://reminiscent-steady-albertosaurus.glitch.me";

	public String getSentence () {
		String strMadlib = "It was a " + getAdjective() +  " day. I went downstairs to see if I could " + getVerb() 
		   + " dinner. I asked, \"Does the stew need fresh " + getNoun()  + "?\"";
		return strMadlib;
	}
	
	private String getAdjective() {
		return getRandomFromUrl(baseUrl + "/adjective");
	}
	
	private String getNoun() {
		return getRandomFromUrl(baseUrl + "/noun");
	}
	
	private String getVerb() {
		return getRandomFromUrl(baseUrl + "/verb");
	}
	
	private String getRandomFromUrl(String strUrl) {
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection )url.openConnection();
			if (conn==null) {
				LOGGER.error("Couldn't connect to the url " + strUrl);
				return null;
			}
			conn.setConnectTimeout(1000);
			
			InputStream in = conn.getInputStream();
			 if (in==null)  {
				LOGGER.error("The url " + strUrl + " returned null");
				return null;
			} 
			 
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        String keyword = reader.readLine();
	        reader.close();
	        conn.disconnect();
		    return keyword;
		} catch (MalformedURLException e) {
			LOGGER.error("The url is malformed." );
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
