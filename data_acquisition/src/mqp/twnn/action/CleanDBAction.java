/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.action;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import mqp.console.Logger;
import mqp.twnn.db.CompanyDatabaseController;
import mqp.twnn.models.Company;

/**
 * Action to remove erraneous instances from the database
 * @author Tyler
 *
 */
public class CleanDBAction implements Action {
	Logger logger;
	CompanyDatabaseController dbController;
	
	public CleanDBAction() {
		logger = Logger.getInstance();
		dbController = new CompanyDatabaseController();
	}
	
	@Override
	public void start() {
		logger.log("Clean DB");
		
		logger.log("Loading symbols");
		List<Company> companies = new LinkedList<Company>();
		companies.addAll(dbController.query());
		
		Iterator<Company> iter = companies.iterator();
		while(iter.hasNext()) {
			Company c = iter.next();
			
			if (c.getHistoricalData().isEmpty()) {
				dbController.delete(c);
				logger.log("Deleted symbol: " + c.getSymbol());
			}
		}
		
		dbController.close();
		logger.log("DB Cleaned.");
	}

}
