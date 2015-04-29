/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import mqp.console.Logger;
import mqp.twnn.db.CompanyDatabaseController;
import mqp.twnn.models.Company;
import mqp.twnn.models.CurrentData;
import mqp.twnn.update.CurrentTickerDataRequester;
import mqp.twnn.update.TickerDataRequester;

/**
 * This class updates current company data using the Yahoo! API
 * @author Tyler
 *
 */
public class UpdateCurrentTickerAction implements Action {
	Logger logger;
	CompanyDatabaseController dbController;
	
	public UpdateCurrentTickerAction() {
		dbController = new CompanyDatabaseController();
		logger = Logger.getInstance();
	}
	
	@Override
	public void start() {
		logger.log("Update Real-Time Ticker Data");
		TickerDataRequester requester = new CurrentTickerDataRequester();
		
		logger.log("Loading symbols");
		List<Company> results = new LinkedList<Company>();
		results.addAll(dbController.query());
		
		Logger.getInstance().log("Sending requests to Yahoo! API");
		Iterator<Company> iter = results.iterator();
		StringBuilder request = new StringBuilder();
		boolean finishedWithErrors = false;
	    
		Map<String, Company> companySet = new HashMap<String, Company>();
		int count = 1;
		while(iter.hasNext()) {
			Company c = iter.next();
			companySet.put(c.getSymbol(), c);
			
			request.append("\"" + c.getSymbol() + "\"");
			
			if (count >= 20 || !(iter.hasNext())) {
				JSONArray jsonResult = requester.getData(request.toString());
				
				finishedWithErrors = finishedWithErrors | processCompanyData(companySet, jsonResult);
				System.out.print(".");
				companySet.clear();
				count = 0;
				request = new StringBuilder();
			} else {
				request.append(", ");
			}
			count++;
		}
		
		if (finishedWithErrors) {
			System.out.println();
			logger.log("Network update finished with errors. Clean DB.");
		}
		dbController.close();
	}

	private boolean processCompanyData(Map<String, Company> companySet,
			JSONArray jsonResult) {
		boolean finishedWithErrors = false;
		
		if (jsonResult == null) {
			logger.error("Result from request was null");
		} else {
			for (int count = 0; count < jsonResult.length(); count++) {
				JSONObject currentObj = jsonResult.getJSONObject(count);
				CurrentData d = new CurrentData();
				
				d.setBid(testDouble(currentObj, "Bid"));
				d.setBookValue(testDouble(currentObj, "BookValue"));
				d.setEarningsShare(testDouble(currentObj, "EarningsShare"));
				d.setEstimateEPSNextQuarter(testDouble(currentObj, "EPSEstimateNextQuarter"));
				d.setEstimateEPSNextYear(testDouble(currentObj, "EPSEstimateNextYear"));
				d.setMovingAverage50Day(testDouble(currentObj, "FiftydayMovingAverage"));
				d.setMovingAverage200Day(testDouble(currentObj, "TwoHundreddayMovingAverage"));
				d.setChangeFrom50DayMovingAverage(testDouble(currentObj, "ChangeFromFiftydayMovingAverage"));
				d.setChangeFrom200DayMovingAverage(testDouble(currentObj, "ChangeFromTwoHundreddayMovingAverage"));
				d.setOpen(testDouble(currentObj, "Open"));
				d.setPreviousClose(testDouble(currentObj, "PreviousClose"));
				d.setPERatio(testDouble(currentObj, "PERatio"));
				d.setPEGRatio(testDouble(currentObj, "PEGRatio"));
				d.setCurrentYearPriceEPSEstimate(testDouble(currentObj, "PriceEPSEstimateCurrentYear"));
				d.setNextYearPriceEPSEstimate(testDouble(currentObj, "PriceEPSEstimateNextYear"));
				d.setShortRatio(testDouble(currentObj, "ShortRatio"));
				d.setAverageVolume(testInt(currentObj, "AverageDailyVolume"));
				d.setCurrentVolume(testInt(currentObj, "Volume"));
				d.setDayHigh(testDouble(currentObj, "DaysHigh"));
				d.setDayLow(testDouble(currentObj, "DaysLow"));
				d.setLastTradePrice(testDouble(currentObj, "LastTradePriceOnly"));
				d.setMarketCap(testString(currentObj, "MarketCapitalization"));
				d.setYearHigh(testDouble(currentObj, "YearHigh"));
				d.setYearLow(testDouble(currentObj, "YearLow"));
				
				String symbol = currentObj.getString("Symbol");
				Company curCompany = companySet.get(symbol);
				
				if (curCompany == null) {
					System.out.println();
					logger.error("Invalid Symbol: " + symbol);
					
					finishedWithErrors = true;
				} else {
					curCompany.setCurrentData(d);
					dbController.store(curCompany);
				}
			}
		}
		
		return finishedWithErrors;
	}

	private String testString(JSONObject currentObj, String string) {
		return (currentObj.isNull(string) ? "" : currentObj.getString(string));
	}

	private int testInt(JSONObject currentObj, String string) {
		return (currentObj.isNull(string) ? -1 : currentObj.getInt(string));
	}

	private double testDouble(JSONObject currentObj, String string) {
		return (currentObj.isNull(string) ? Double.NaN : currentObj.getDouble(string));
	}
}
