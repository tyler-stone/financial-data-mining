/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.models;

/**
 * Container for all current company data
 * @author Tyler
 *
 */
public class CurrentData {
	private String marketCap;
	private Integer currentVolume;
	private Integer averageVolume;
	private Double lastTradePrice;
	private Double yearLow;
	private Double yearHigh;
	private Double dayHigh;
	private Double dayLow;
	private Double open;
	private Double currentYearPriceEPSEstimate;
	private Double nextYearPriceEPSEstimate;
	private Double bookValue;
	private Double bid;
	private Double changeFrom50DayMovingAverage;
	private Double changeFrom200DayMovingAverage;
	private Double movingAverage200Day;
	private Double movingAverage50Day;
	private Double PERatio;
	private Double PEGRatio;
	private Double estimateEPSNextQuarter;
	private Double estimateEPSNextYear;
	private Double earningsShare;
	private Double shortRatio;
	private Double previousClose;
	
	public CurrentData() {
		marketCap = "";
		currentVolume = -1;
		averageVolume = -1;
		lastTradePrice = Double.NaN;
		yearLow = Double.NaN;
		yearHigh = Double.NaN;
		dayHigh = Double.NaN;
		dayLow = Double.NaN;
		open = Double.NaN;
		currentYearPriceEPSEstimate = Double.NaN;
		nextYearPriceEPSEstimate = Double.NaN;
		bookValue = Double.NaN;
		bid = Double.NaN;
		changeFrom50DayMovingAverage = Double.NaN;
		changeFrom200DayMovingAverage = Double.NaN;
		movingAverage200Day = Double.NaN;
		movingAverage50Day = Double.NaN;
		PERatio = Double.NaN;
		PEGRatio = Double.NaN;
		estimateEPSNextQuarter = Double.NaN;
		estimateEPSNextYear = Double.NaN;
		earningsShare = Double.NaN;
		shortRatio = Double.NaN;
		previousClose = Double.NaN;
	}

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public Double getYearLow() {
		return yearLow;
	}

	public void setYearLow(Double yearLow) {
		this.yearLow = yearLow;
	}

	public Double getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(Double yearHigh) {
		this.yearHigh = yearHigh;
	}

	public Integer getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(Integer currentVolume) {
		this.currentVolume = currentVolume;
	}

	public Integer getAverageVolume() {
		return averageVolume;
	}

	public void setAverageVolume(Integer averageVolume) {
		this.averageVolume = averageVolume;
	}

	public Double getLastTradePrice() {
		return lastTradePrice;
	}

	public void setLastTradePrice(Double lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
	}

	public Double getDayHigh() {
		return dayHigh;
	}

	public void setDayHigh(Double dayHigh) {
		this.dayHigh = dayHigh;
	}

	public Double getDayLow() {
		return dayLow;
	}

	public void setDayLow(Double dayLow) {
		this.dayLow = dayLow;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getBookValue() {
		return bookValue;
	}

	public void setBookValue(Double bookValue) {
		this.bookValue = bookValue;
	}

	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}

	public Double getChangeFrom50DayMovingAverage() {
		return changeFrom50DayMovingAverage;
	}

	public void setChangeFrom50DayMovingAverage(Double changeFrom50DayMovingAverage) {
		this.changeFrom50DayMovingAverage = changeFrom50DayMovingAverage;
	}

	public Double getChangeFrom200DayMovingAverage() {
		return changeFrom200DayMovingAverage;
	}

	public void setChangeFrom200DayMovingAverage(
			Double changeFrom200DayMovingAverage) {
		this.changeFrom200DayMovingAverage = changeFrom200DayMovingAverage;
	}
	
	public Double getMovingAverage200Day() {
		return movingAverage200Day;
	}

	public void setMovingAverage200Day(Double movingAverage200Day) {
		this.movingAverage200Day = movingAverage200Day;
	}

	public Double getMovingAverage50Day() {
		return movingAverage50Day;
	}

	public void setMovingAverage50Day(Double movingAverage50Day) {
		this.movingAverage50Day = movingAverage50Day;
	}

	public Double getPERatio() {
		return PERatio;
	}

	public void setPERatio(Double pERatio) {
		PERatio = pERatio;
	}

	public Double getPEGRatio() {
		return PEGRatio;
	}

	public void setPEGRatio(Double pEGRatio) {
		PEGRatio = pEGRatio;
	}

	public Double getEstimateEPSNextQuarter() {
		return estimateEPSNextQuarter;
	}

	public void setEstimateEPSNextQuarter(Double estimateEPSNextQuarter) {
		this.estimateEPSNextQuarter = estimateEPSNextQuarter;
	}

	public Double getEstimateEPSNextYear() {
		return estimateEPSNextYear;
	}

	public void setEstimateEPSNextYear(Double estimateEPSNextYear) {
		this.estimateEPSNextYear = estimateEPSNextYear;
	}

	public Double getEarningsShare() {
		return earningsShare;
	}

	public void setEarningsShare(Double earningsShare) {
		this.earningsShare = earningsShare;
	}

	public Double getShortRatio() {
		return shortRatio;
	}

	public void setShortRatio(Double shortRatio) {
		this.shortRatio = shortRatio;
	}

	public Double getCurrentYearPriceEPSEstimate() {
		return currentYearPriceEPSEstimate;
	}

	public void setCurrentYearPriceEPSEstimate(Double currentYearPriceEPSEstimate) {
		this.currentYearPriceEPSEstimate = currentYearPriceEPSEstimate;
	}

	public Double getNextYearPriceEPSEstimate() {
		return nextYearPriceEPSEstimate;
	}

	public void setNextYearPriceEPSEstimate(Double nextYearPriceEPSEstimate) {
		this.nextYearPriceEPSEstimate = nextYearPriceEPSEstimate;
	}

	public Double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}
	
	
	/**
	 * Check if an object has a value
	 * @param o the object to check
	 * @return whether or not the object has a value
	 */
	public boolean hasValue(Object o) {
		boolean hasValue = true;
		if (o instanceof Double) {
			if (((Double) o).isNaN()) {
				hasValue = false;
			}
		} 
		else if (o instanceof Integer) {
			if (((Integer) o) == -1) {
				hasValue = false;
			}
		}
		else if (o instanceof String) {
			if (((String) o).equals("")) {
				hasValue = false;
			}
		} else {
			hasValue = false;
		}
		
		return hasValue;
	}
}
