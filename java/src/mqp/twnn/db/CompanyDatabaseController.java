/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.db;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import mqp.twnn.models.Company;

/**
 * Controls interactions with the company database
 * @author Tyler
 *
 */
public class CompanyDatabaseController {
	private static final String DB_FILE = "companies";
	private ObjectContainer db;
	
	public CompanyDatabaseController() {
		DatabaseConnection dbConnection = new DatabaseConnection(DB_FILE);
		db = dbConnection.getConnection();
	}

	/**
	 * Stores a company to the database
	 * @param company the company to store
	 */
	public void store(Company company) {
		db.store(company);
	}

	/**
	 * Query all companies in the database
	 * @return all companies in the database
	 */
	public List<Company> query() {
		return db.query(Company.class);
	}
	
	public ObjectSet<Company> querySet() {
		return db.query(Company.class);
	}
	
	/**
	 * Delete an object from the database
	 * @param obj the object to delete
	 */
	public void delete(Object obj) {
		db.delete(obj);
	}
	
	/**
	 * Send modifications to the disk
	 */
	public void commit() {
		db.commit();
	}
	
	/**
	 * Close the database connection
	 */
	public void close() {
		db.close();
	}

}
