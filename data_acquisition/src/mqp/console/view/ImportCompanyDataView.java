/**
 * MQP - Trading With Neural Networks
 * Tyler Stone & Ryan McKenna
 * 2014
 */
package mqp.console.view;

/**
 * The view for the import company data option
 * @author Tyler
 */
public class ImportCompanyDataView implements ConsoleView {
	
	@Override
	public void displayMenu(int menu) {
		displaySplash();
		displayMenu();
	}

	private void displayMenu() {
		System.out.println("Please enter your file location:");
	}

	private void displaySplash() {
		System.out.println("Import Company Data from CSV");
		System.out.println("IMPORTANT:");
		System.out.println("Your file must be in CSV format, with the following columns:");
		System.out.println("\tSYMBOL");
		System.out.println("\tNAME");
		System.out.println("\tSECTOR");
		System.out.println("\tINDUSTRY");
		System.out.println("\tEXCHANGE");
		System.out.println();
	}
}
