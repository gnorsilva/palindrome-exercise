package com.gnorsilva.palindrome;


public class PalindromeApplication {

	private PalindromeView applicationView;
	private PalindromeService palindromeService;
	
	public PalindromeApplication(PalindromeView applicationView,
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