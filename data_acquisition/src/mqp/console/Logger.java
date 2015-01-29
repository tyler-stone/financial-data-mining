/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console;
import mqp.console.controller.GeneralConsoleController;

/**
 * Singleton to handle logging to the console
 * @author Tyler
 *
 */
public class Logger extends GeneralConsoleController {
	private static Logger logger = new Logger();
	
	public static Logger getInstance() {
		return logger;
	}
}
