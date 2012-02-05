package com.gnorsilva.palindrome;

public class StartPalindromaton {
	
	public static void main(String[] args) {
		PalindromatonConsole console = new PalindromatonConsole();
		PalindromeView view = new PalindromeView(console);
		
		PalindromeService service = new PalindromeService();
		
		PalindromeApplication app = new PalindromeApplication(view, service);
		
		app.start();
	}

}
