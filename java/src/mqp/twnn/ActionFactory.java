/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.twnn;

import mqp.console.controller.InteractingConsoleController;
import mqp.console.validate.NoValidationRequiredValidator;
import mqp.console.view.ImportCompanyDataView;
import mqp.twnn.action.Action;
import mqp.twnn.action.CleanDBAction;
import mqp.twnn.action.ExportCurrentTickerAction;
import mqp.twnn.action.ExportHistoricalTickerAction;
import mqp.twnn.action.ImportCompanyDataAction;
import mqp.twnn.action.UpdateCurrentTickerAction;
import mqp.twnn.action.UpdateHistoricalTickerAction;

/**
 * Generates an action based on input
 * @author Tyler
 */
public class ActionFactory {
	public static final String IMPORT_COMPANY_DATA = "1";
	public static final String UPDATE_REALTIME_TICKER_DB = "2";
	public static final String EXPORT_REALTIME_TICKER_DB = "3";
	public static final String UPDATE_HISTORICAL_TICKER_DB = "4";
	public static final String EXPORT_HISTORICAL_TICKER_DB = "5";
	public static final String CLEAN_DB = "6";
	
	private static final ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	/**
	 * Makes an action
	 * @param actionString the action requested by the user
	 * @return the action related to that option
	 */
	public static Action makeAction(String actionString) {
		Action action = null;
		
		switch(actionString) {
		case IMPORT_COMPANY_DATA:
			action = new ImportCompanyDataAction(
					new InteractingConsoleController(new ImportCompanyDataView(), new NoValidationRequiredValidator()));
			break;
		case UPDATE_REALTIME_TICKER_DB:
			action = new UpdateCurrentTickerAction();
			break;
		case EXPORT_REALTIME_TICKER_DB:
			action = new ExportCurrentTickerAction();
			break;
		case UPDATE_HISTORICAL_TICKER_DB:
			action = new UpdateHistoricalTickerAction();
			break;
		case EXPORT_HISTORICAL_TICKER_DB:
			action = new ExportHistoricalTickerAction();
			break;
		case CLEAN_DB:
			action = new CleanDBAction();
			break;
		default:
			System.exit(0);
		}
		
		return action;
	}
}
