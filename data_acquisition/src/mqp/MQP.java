/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp;

import mqp.console.controller.InteractingConsoleController;
import mqp.console.validate.MainMenuValidator;
import mqp.console.view.MainMenuView;
import mqp.twnn.ActionFactory;

/**
 * Primary entry point for MQP application
 * @author Tyler
 *
 */
public class MQP {
	/**
	 * Primary entry point for MQP application
	 * @param args
	 */
	public static void main(String[] args) {
		InteractingConsoleController c = new InteractingConsoleController(new MainMenuView(), 
				new MainMenuValidator());
		
		String action = c.getInteraction();
		ActionFactory.makeAction(action).start();
	}
}
