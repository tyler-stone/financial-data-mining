/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.validate;

/**
 * Validator for the main application menu
 * @author Tyler
 */
public class MainMenuValidator implements OptionValidator {
	private static final int MAIN_MENU = 0;
	
	@Override
	public boolean validate(String option, int menu) {
		boolean valid = false;
		
		if (menu == MAIN_MENU) {
			valid = option.matches("(1|2|3|4|5|6)");
		}
				
		return valid;
	}
}
