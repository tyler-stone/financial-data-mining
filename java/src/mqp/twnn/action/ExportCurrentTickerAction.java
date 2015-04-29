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
import mqp.twnn.models.CurrentData;

/**
 * Exports current data regarding stocks to a file
 * @author Tyler
 *
 */
public class ExportCurrentTickerAction implements Action {
	private static final int MAX_AVG_VOLUME = 1000000;
	Logger logger;
	CSVWriter csvWriter;
	
	public ExportCurrentTickerAction() {
		csvWriter = new CSVWriter("C:\\currentData.csv");
		logger = Logger.getInstance();
	}

	@Override
	public void start() {
		logger.log("Export Company Data");
		logger.log("Exporting to file");
		CompanyDatabaseController dbController = new CompanyDatabaseController();
		ObjectSet<Company> companies = dbController.querySet();
		
		csvWriter.addRow("Symbol, Sector,"
				+ " Market Cap, Average Volume,"
				+ " Current Volume, Previous Close, Open, Bid, Book Value, Last Trade Price,"
				+ " 200 Day Moving Average, 50 Day Moving Average, Change from 200 Day,"
				+ " Change from 50 Day, Earnings Share, Estimate EPS Next Quarter,"
				+ " Estimate EPS Next Year, Next Year EPS Price Estimate, Current Year Price EPS Estimate,"
				+ " Day High, Day Low, Year High, Year Low, PEG Ratio, PE Ratio, Short Ratio");
		
		for (int count = 0; count < companies.size(); count++) {
			Company company = companies.get(count);
			CurrentData curData = company.getCurrentData();
			
			if (curData.getAverageVolume() > MAX_AVG_VOLUME) {
				csvWriter.addItem(company.getSymbol());
				csvWriter.addItem(company.getSector());
				
				checkAndAddString(curData, curData.getMarketCap());
				checkAndAddInt(curData, curData.getAverageVolume());
				checkAndAddInt(curData, curData.getCurrentVolume());
				checkAndAddDouble(curData, curData.getPreviousClose());
				checkAndAddDouble(curData, curData.getOpen());
				checkAndAddDouble(curData, curData.getBid());
				checkAndAddDouble(curData, curData.getBookValue());
				checkAndAddDouble(curData, curData.getLastTradePrice());
				
				checkAndAddDouble(curData, curData.getMovingAverage200Day());
				checkAndAddDouble(curData, curData.getMovingAverage50Day());
				checkAndAddDouble(curData, curData.getChangeFrom200DayMovingAverage());
				checkAndAddDouble(curData, curData.getChangeFrom50DayMovingAverage());
				
				checkAndAddDouble(curData, curData.getEarningsShare());
				checkAndAddDouble(curData, curData.getEstimateEPSNextQuarter());
				checkAndAddDouble(curData, curData.getEstimateEPSNextYear());
				checkAndAddDouble(curData, curData.getNextYearPriceEPSEstimate());
				checkAndAddDouble(curData, curData.getCurrentYearPriceEPSEstimate());
				
				checkAndAddDouble(curData, curData.getDayHigh());
				checkAndAddDouble(curData, curData.getDayLow());
				checkAndAddDouble(curData, curData.getYearHigh());
				checkAndAddDouble(curData, curData.getYearLow());
	
				checkAndAddDouble(curData, curData.getPEGRatio());
				checkAndAddDouble(curData, curData.getPERatio());
				checkAndAddDouble(curData, curData.getShortRatio());
				
				csvWriter.newLine();
			}
		}
		csvWriter.finish();
		logger.log("Done");
	}
	
	private void checkAndAddInt(CurrentData curData, Integer val) {
		if (curData.hasValue(val)) {
			csvWriter.addItem(val.toString());
		} else {
			csvWriter.addEmptyColumn();
		}
	}
	
	private void checkAndAddDouble(CurrentData curData, Double val) {
		if (curData.hasValue(val)) {
			csvWriter.addItem(val.toString());
		} else {
			csvWriter.addEmptyColumn();
		}
	}
	
	private void checkAndAddString(CurrentData curData, String val) {
		if (curData.hasValue(val)) {
			csvWriter.addItem(val.toString());
		} else {
			csvWriter.addEmptyColumn();
		}
	}

}
