package com.gnorsilva.palindrome;

public class ApplicationView {

	public static final String TYPE_ANY_TEXT = "Type any text: ";
	public static final String NOT_A_PALINDROME_MSG = "Text is not a palindrome";
	public static final String IS_A_PALINDROME_MSG = "Text is a palindrome";
	
	private PalindromatonConsole console;	
	
	public ApplicationView(PalindromatonConsole palindromatonConsole) {
		this.console = palindromatonConsole;
	}

	public String askUserForText() {
		console.write(TYPE_ANY_TEXT);
		return console.readInput();
	}

	public void informResultIs(boolean isPalindrome) {
		String resultMessage = isPalindrome ? IS_A_PALINDROME_MSG : NOT_A_PALINDROME_MSG;
		console.write(resultMessage);
	}

}
