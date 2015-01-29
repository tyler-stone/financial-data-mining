/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn.update;

import org.json.JSONArray;

/**
 * Requests data in the form of JSON objects
 * @author Tyler
 *
 */
public interface TickerDataRequester {
	/**
	 * Get data for a specific company
	 * @param requestString the request url
	 * @return a JSONArray of that data
	 */
	JSONArray getData(String requestString);
}
