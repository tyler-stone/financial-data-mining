/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.update;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import mqp.console.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Requests current data for all companies in a DB
 * @author Tyler
 */
public class CurrentTickerDataRequester implements TickerDataRequester {
	private static final String REQUEST_URL = "query.yahooapis.com";
	private static final int MAX_ATTEMPTS = 10;
	
	@Override
	public JSONArray getData(String requestString) {
		Request request = new Request();
		String query = "select * from yahoo.finance.quotes where symbol in (" + requestString + ")&format=json&env=store://datatables.org/alltableswithkeys&callback=";
		URI fullQuery = null;
		JSONObject json;
		JSONArray result = null;
		int attempts = 1;
		boolean isNull = true;
		
		try {
			while (isNull && attempts <= MAX_ATTEMPTS) {
				fullQuery = new URI("https", REQUEST_URL, "/v1/public/yql", "q=" + query, null);
				json = request.getJSON(fullQuery.toURL());
				
				isNull = (json.getJSONObject("query").isNull("results"));
				if (!isNull) {
					result = json.getJSONObject("query")
							.getJSONObject("results").getJSONArray("quote");
				}
				attempts++;
			}
			
			if (attempts > MAX_ATTEMPTS) {
				Logger.getInstance().error("Max attempts to receive data reached.");
			}
		} catch (URISyntaxException e) {
			Logger.getInstance().error("Bad URL encode");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			Logger.getInstance().error("Malformed URL");
			e.printStackTrace();
		}
		
		return result;
	}

}
