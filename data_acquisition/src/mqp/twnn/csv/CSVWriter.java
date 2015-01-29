/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.csv;

import java.io.FileWriter;
import java.io.IOException;

import mqp.console.Logger;

/**
 * Writes objects to a CSV file
 * @author Tyler
 *
 */
public class CSVWriter {
	private FileWriter file;

	/**
	 * Constructor for CSVWriter
	 * @param fileLoc the location of the file to write to
	 */
	public CSVWriter(String fileLoc) {
		try {
			file = new FileWriter(fileLoc);
		} catch (IOException e) {
			Logger.getInstance().error("Could not create export file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a row to the CSV writer
	 * @param csvRow the row in string form to add
	 */
	public void addRow(String csvRow) {
		try {
			file.append(csvRow);
			file.append('\n');
		} catch (IOException e) {
			Logger.getInstance().error("Could not add string to file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a single item to a row and append a comma to the end of the item
	 * @param item the string to add to the row
	 */
	public void addItem(String item) {
		try {
			file.append(item);
			file.append(',');
		} catch (IOException e) {
			Logger.getInstance().error("Could not add string to file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Add no data and just append a comma, signifying an empty cell
	 */
	public void addEmptyColumn() {
		try {
			file.append(',');
		} catch (IOException e) {
			Logger.getInstance().error("Could not add string to file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Add a new line to the CSV
	 */
	public void newLine() {
		try {
			file.append('\n');
		} catch (IOException e) {
			Logger.getInstance().error("Could not add string to file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Close the file
	 */
	public void finish() {
		try {
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
