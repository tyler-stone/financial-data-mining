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
import java.util.ArrayList;
import java.util.List;

import mqp.console.Logger;
import mqp.twnn.models.HistoricalEntry;

/**
 * Requests all historical data for a company and parses it 
 * @author Tyler
 *
 */
public class HistoricalCSVRequest {
	
	/**
	 * Get all historical entries from a connection
	 * @param url the url to connect to to get the information
	 * @return a list of historical entries
	 */
	public List<HistoricalEntry> getHistoricalEntries(URL url) {
		List<HistoricalEntry> entries = new ArrayList<HistoricalEntry>();
		
		try {
			//open connection
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			//get response
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			
			//format response line to object
			while ((inputLine = in.readLine()) != null) {
				if (!(inputLine.contains("Date"))) {
					HistoricalEntry newEntry = new HistoricalEntry();
					String[] cData = inputLine.split(",");
					newEntry.setDate(cData[0]);
					newEntry.setOpen(Double.parseDouble(cData[1]));
					newEntry.setHigh(Double.parseDouble(cData[2]));
					newEntry.setLow(Double.parseDouble(cData[3]));
					newEntry.setClose(Double.parseDouble(cData[4]));
					newEntry.setAdjClose(Double.parseDouble(cData[5]));
					entries.add(newEntry);
				}
			}
			in.close();
		} catch(IOException e) {
			Logger.getInstance().error("HTTP failure");
			e.printStackTrace();
		}
		
		return entries;
	}
	
}
