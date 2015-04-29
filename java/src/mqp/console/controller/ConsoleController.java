/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.controller;

/**
 * The general controller for a console which contains
 * the basic methods needed to display information
 * @author Tyler
 *
 */
public interface ConsoleController {
	/**
	 * Log information to the screen
	 * @param data the information to show
	 */
	void log(String data);
	
	/**
	 * Show an error on the screen
	 * @param err the error to show
	 */
	void error(String err);
}
