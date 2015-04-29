/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.action;

import java.util.Iterator;
import java.util.List;

import mqp.console.Logger;
import mqp.console.controller.InteractingConsoleController;
import mqp.twnn.csv.CompanyCSVReader;
import mqp.twnn.db.CompanyDatabaseController;
import mqp.twnn.models.Company;

/**
 * This action imports company symbols from a CSV file
 * @author Tyler
 *
 */
public class ImportCompanyDataAction implements Action {
	Logger logger;
	InteractingConsoleController console;
	
	/**
	 * Constructor for the action
	 * @param console the console provided to interact with the user
	 */
	public ImportCompanyDataAction(InteractingConsoleController console) {
		logger = Logger.getInstance();
		this.console = console;
	}
	
	@Override
	public void start() {
		String fileLocation = console.getInteraction();
		CompanyCSVReader csvReader = new CompanyCSVReader();
		CompanyDatabaseController dbController = new CompanyDatabaseController();
		
		List<Company> results = csvReader.readFile(fileLocation);
		
		Iterator<Company> iter = results.iterator();
		while(iter.hasNext()) {
			Company company = iter.next();
			dbController.store(company);
			console.log("Added " + company.getSymbol() + " to database");
		}
		
		dbController.close();
		console.log(results.size() + " companies were added to the database");
	}

}
