/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.db;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

/**
 * Controls the database connection
 * @author Tyler
 */
public class DatabaseConnection {
	ObjectContainer db;
	
	/**
	 * Constructor for the connection
	 * @param file the database file to connect to
	 */
	public DatabaseConnection(String file) {
		db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), file);
	}
	
	/**
	 * Get the database connection
	 * @return the connection
	 */
	public ObjectContainer getConnection() {
		return db;
	}
	
	/**
	 * Closes the database
	 */
	public void close() {
		db.close();
	}

}
