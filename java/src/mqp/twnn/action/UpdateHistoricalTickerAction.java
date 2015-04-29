/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.db4o.ObjectSet;

import mqp.console.Logger;
import mqp.twnn.db.CompanyDatabaseController;
import mqp.twnn.models.Company;
import mqp.twnn.models.HistoricalEntry;
import mqp.twnn.update.HistoricalTickerDataRequester;

/**
 * This action updates historical data using the Yahoo! API
 * @author Tyler
 *
 */
public class UpdateHistoricalTickerAction implements Action {
	private static final int MAX_PER_ITERATION = 300;
	Logger logger;
	CompanyDatabaseController dbController;
	
	public UpdateHistoricalTickerAction() {
		logger = Logger.getInstance();
		dbController = new CompanyDatabaseController();
	}
	
	@Override
	public void start() {
		logger.log("Update Historical Ticker Data");
		HistoricalTickerDataRequester requester = new HistoricalTickerDataRequester();
		
		logger.log("Loading symbols");
		ObjectSet<Company> results = dbController.querySet();
		
		Logger.getInstance().log("Sending requests to Yahoo! API");
		Iterator<Company> iter = results.iterator();
		boolean finishedWithErrors = false;
		List<HistoricalEntry> entries = new ArrayList<HistoricalEntry>();
		
		int count = 1;
		while(iter.hasNext()) {
			Company c = iter.next();
			
			if (c.getHistoricalData().isEmpty()) {
				String ticker = c.getSymbol();
				
				entries = requester.getData(ticker);
				
				finishedWithErrors |= entries.isEmpty();
				c.setHistoricalData(entries);
				dbController.store(c);
				dbController.commit();
				logger.log("[" + count + " of " + results.size() + "] " + ticker + ": " + entries.size() + " historical entries added");
			}
			
			c = null;
			count++;
		}
		
		if (finishedWithErrors) {
			System.out.println();
			logger.log("Network update finished with errors. Clean DB.");
		}
		
		dbController.close();
	}
}
