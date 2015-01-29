/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.models;

import java.util.ArrayList;
import java.util.List;

/**
 * A company object
 * @author Tyler
 */
public class Company {
	String symbol;
	String name;
	String sector;
	String industry;
	String exchange;
	
	CurrentData currentData;
	List<HistoricalEntry> historicalData;
	
	/**
	 * Constructor for a company
	 * @param symbol the stock symbol for the company
	 * @param name the name of the company
	 * @param sector the sector of the company
	 * @param industry the industry of the company
	 * @param exchange the exchange that the company trades on
	 */
	public Company(String symbol, String name, String sector, String industry, String exchange) {
		this.symbol = symbol;
		this.name = name;
		this.sector = sector;
		this.industry = industry;
		this.exchange = exchange;
		currentData = new CurrentData();
		historicalData = new ArrayList<HistoricalEntry>();
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

	public String getSector() {
		return sector;
	}

	public String getIndustry() {
		return industry;
	}

	public String getExchange() {
		return exchange;
	}
	
	public CurrentData getCurrentData() {
		return currentData;
	}
	
	public void setCurrentData(CurrentData currentData) {
		this.currentData = currentData;
	}
	
	public List<HistoricalEntry> getHistoricalData() {
		return historicalData;
	}
	
	public void setHistoricalData(List<HistoricalEntry> historicalData) {
		this.historicalData = historicalData;
	}
}
