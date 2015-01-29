/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.controller;

/**
 * A simple implementation of the console controller
 * @author Tyler
 *
 */
public class GeneralConsoleController implements ConsoleController {
	@Override
	public void log(String data) {
		System.out.println("[INFO] " + data);
	}
	
	@Override
	public void error(String err) {
		System.out.println("[ERROR] " + err);
	}
}
