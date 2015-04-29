/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.view;

/**
 * The main menu display
 * @author Tyler
 */
public class MainMenuView implements ConsoleView {
	public void displayMenu(int menu) {
		displaySplash();
		displayOptions();
	}
	
	/**
	 * The splash screen for the project
	 */
	public void displaySplash() {
		System.out.println("Trading With Neural Networks");
		System.out.println("Ryan McKenna & Tyler Stone");
		System.out.println();
	}
	
	/**
	 * The options for the project
	 */
	public void displayOptions() {
		System.out.println("1. Import company data");
		System.out.println("2. Update real-time ticker data");
		System.out.println("3. Export real-time ticker data");
		System.out.println("4. Update historical ticker data");
		System.out.println("5. Export historical ticker data");
		System.out.println("6. Clean DB based on historical data");
		//cluster analysis
		//ann?
	}
}
