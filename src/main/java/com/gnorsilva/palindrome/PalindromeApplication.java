package com.gnorsilva.palindrome;


public class PalindromeApplication {

	private ApplicationView applicationView;
	private PalindromeService palindromeService;
	public static final String WELCOME_MESSAGE = "Welcome to Palindrome Application";
	
	public PalindromeApplication(ApplicationView applicationView,
			PalindromeService palindromeService) {
		this.applicationView = applicationView;
		this.palindromeService = palindromeService;
	}

	public void start() {
		String userInput = applicationView.askUserForText();
		boolean isPalindrome = palindromeService.isPalindrome(userInput);
		applicationView.informResultIs(isPalindrome);
	}

}