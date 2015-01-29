/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains a record of the company trading information on 
 * a specific day
 * @author Tyler
 *
 */
public class HistoricalEntry {
	private Date date;
	private Double open;
	private Double high;
	private Double low;
	private Double close;
	private Integer volume;
	private Double adjClose;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * Set the date for the historical entry
	 * @param date
	 */
	public void setDate(String date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.date = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getClose() {
		return close;
	}

	public void setClose(Double close) {
		this.close = close;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getAdjClose() {
		return adjClose;
	}

	public void setAdjClose(Double adjClose) {
		this.adjClose = adjClose;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}
}
