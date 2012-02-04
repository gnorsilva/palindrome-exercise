package com.gnorsilva.palindrome;

public class StartPalindromatron {
	
	public static void main(String[] args) {
		PalindromatonConsole console = new PalindromatonConsole();
		ApplicationView view = new ApplicationView(console);
		
		PalindromeService service = new PalindromeService();
		
		PalindromeApplication app = new PalindromeApplication(view, service);
		
		app.start();
	}

}
