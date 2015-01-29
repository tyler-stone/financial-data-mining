/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import mqp.console.Logger;

import org.json.JSONObject;

/**
 * A generic web request which returns JSON
 * @author Tyler
 *
 */
public class Request {
	
	/**
	 * Get a JSON response to a web request
	 * @param url the url to send the request to
	 * @return a JSONObject containing all data
	 */
	public JSONObject getJSON(URL url) {
		StringBuffer response = new StringBuffer();
		int retries = 0;
		boolean shouldRetry = true;
		
		while (shouldRetry) {
			try {
				//open connection
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				
				//get response
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				
				//format response to string
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				shouldRetry = false;
			} catch(IOException e) {
				Logger.getInstance().error("HTTP failure");
				retries ++;
				if (retries > 3) {
					shouldRetry = false;
					e.printStackTrace();
				}
			}
		}
		
		//format to json
		return new JSONObject(response.toString());
	}
}
