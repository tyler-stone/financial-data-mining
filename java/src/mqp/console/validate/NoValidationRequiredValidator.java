/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.validate;


/**
 * A validator which simply returns true, meaning that any input is accepted
 * @author Tyler
 *
 */
public class NoValidationRequiredValidator implements OptionValidator {

	@Override
	public boolean validate(String option, int menu) {
		return true;
	}

}
