/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.controller;

import java.util.Scanner;

import mqp.console.validate.OptionValidator;
import mqp.console.view.ConsoleView;

/**
 * A console controller which requests information from the user
 * @author Tyler
 *
 */
public class InteractingConsoleController extends GeneralConsoleController {
	ConsoleView view;
	OptionValidator validator;
	Scanner in;
	
	/**
	 * A console controlle that interacts with the user by getting input
	 * @param view the specific view that the user is receiving
	 * @param validator the validator for the interaction
	 */
	public InteractingConsoleController(ConsoleView view, OptionValidator validator) {
		this.view = view;
		this.validator = validator;
		in = new Scanner(System.in);
	}
	
	/**
	 * Waits to receive an interaction from the user (using the first menu)
	 * @return the response from the user
	 */
	public String getInteraction() {
		return getInteraction(0);
	}
	
	/**
	 * Waits to receive an interaction from the user
	 * @param menu the menu to get the interaction from
	 * @return the response from the user
	 */
	public String getInteraction(int menu) {
		String response = "";
		
		view.displayMenu(menu);
		response = in.next();
		
		if (!(validator.validate(response, menu))) {
			error("Input was not valid.");
			System.exit(0);
		}
		
		return response;
	}
}
