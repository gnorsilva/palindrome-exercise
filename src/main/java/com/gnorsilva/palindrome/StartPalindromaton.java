package com.gnorsilva.palindrome;

public class StartPalindromaton {
	
	public static void main(String[] args) {
		PalindromatonConsole console = new PalindromatonConsole();
		PalindromeView view = new PalindromeView(console);
		
		PersistenceService persistenceService = new PersistenceService();
		persistenceService.setKnownPalindromes("Madam", "Malayalam");
		PalindromeService service = new PalindromeService(persistenceService);
		
		PalindromeApplication app = new PalindromeApplication(view, service);		
		app.start();
	}

}
