/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.update;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import mqp.console.Logger;
import mqp.twnn.models.HistoricalEntry;

/**
 * Sends web requests to get historical company data
 * @author Tyler
 *
 */
public class HistoricalTickerDataRequester {
	private static final String REQUEST_URL = "ichart.finance.yahoo.com";
	private static final int MAX_ATTEMPTS = 10;

	/**
	 * Get all historical data regarding a company
	 * @param ticker the company symbol
	 * @return a list of all historical entries for that company
	 */
	public List<HistoricalEntry> getData(String ticker) {
		HistoricalCSVRequest request = new HistoricalCSVRequest();
		URI fullQuery = null;
		List<HistoricalEntry> result = new ArrayList<HistoricalEntry>();
		int attempts = 1;
		
		try {
			while (result.isEmpty() && attempts <= MAX_ATTEMPTS) {
				fullQuery = new URI("http", REQUEST_URL, "/table.csv", "s=" + ticker, null);
				result = request.getHistoricalEntries(fullQuery.toURL());
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
