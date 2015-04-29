/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.action;

import java.util.LinkedList;
import java.util.List;

import com.db4o.ObjectSet;

import mqp.console.Logger;
import mqp.twnn.csv.CSVWriter;
import mqp.twnn.db.CompanyDatabaseController;
import mqp.twnn.models.Company;
import mqp.twnn.models.HistoricalEntry;

/**
 * Exports historical data to a file
 * @author Tyler
 *
 */
public class ExportHistoricalTickerAction implements Action {
	private static final int MIN_ENTRIES_REQUIRED = 2016;
	Logger logger;
	CSVWriter csvWriter;
	
	public ExportHistoricalTickerAction() {
		csvWriter = new CSVWriter("C:\\historicalData.csv");
		logger = Logger.getInstance();
	}
	
	@Override
	public void start() {
		logger.log("Export Company Data");
		logger.log("Exporting to file");
		CompanyDatabaseController dbController = new CompanyDatabaseController();
		//List<Company> companies = new LinkedList<Company>();
		ObjectSet<Company> companies = dbController.querySet();
		
		for (int count = 0; count < companies.size(); count++) {
			Company company = companies.get(count);
			List<HistoricalEntry> histData = company.getHistoricalData();
			
			if (histData.size() > MIN_ENTRIES_REQUIRED) {
				csvWriter.addItem(company.getSymbol());
				for (int day = MIN_ENTRIES_REQUIRED - 1; day >= 0; day--) {
					csvWriter.addItem(histData.get(day).getClose().toString());
				}
				csvWriter.newLine();
			}
		}
		
		csvWriter.finish();
		logger.log("Done");
	}

}
