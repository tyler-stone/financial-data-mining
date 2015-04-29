/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.validate;

/**
 * Validate user input depending on the options available and
 * the input provided from the user
 * @author Tyler
 *
 */
public interface OptionValidator {
	/**
	 * function to validate input from the user depending on the menu
	 * @param option the option that the user provided
	 * @param menu the menu that the user is on
	 * @return whether or not the option is valid
	 */
	boolean validate(String option, int menu);
}
