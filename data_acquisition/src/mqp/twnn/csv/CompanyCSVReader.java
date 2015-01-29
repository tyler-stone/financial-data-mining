/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mqp.console.Logger;
import mqp.twnn.models.Company;

/**
 * A CSV reader which reads a CSV file and returns company objects
 * @author Tyler
 *
 */
public class CompanyCSVReader {
	
	/**
	 * Read a file and convert the data into company objects
	 * @param file the file to read
	 * @return a list of company objects
	 */
	public List<Company> readFile(String file) {
		BufferedReader br = null;
		String line = "";
		String splitBy = ",";
		List<Company> companies = new ArrayList<Company>();

		try {
			br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {

				// split on comma(',')
				String[] cData = line.split(splitBy);

				// create company object to store values
				Company company = new Company(cData[0], cData[1], cData[2],
						cData[3], cData[4]);

				// adding car objects to a list
				companies.add(company);
			}
		} catch (FileNotFoundException e) {
			Logger.getInstance().error("CSV file not found");
			e.printStackTrace();
		} catch (IOException e) {
			Logger.getInstance().error("CSV file parse failed");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					Logger.getInstance().error("Cannot close CSV file buffer");
					e.printStackTrace();
				}
			}
		}
		
		return companies;
	}
	
	
}
