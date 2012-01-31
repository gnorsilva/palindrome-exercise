package com.gnorsilva.palindrome;

import java.io.Console;
import java.io.PrintWriter;

public class PalindromeApplication {

	public static final String WELCOME_MESSAGE = "Welcome to Palindrome Application";
	public static final String TYPE_A_WORD = "Type a word: ";
	
	private Console console;

	public PalindromeApplication(Console console) {
		this.console = console;
	}

	public void isPalindrome(String string) {
		// TODO Auto-generated method stub
	}

	public void start() {
		console.writer().println(WELCOME_MESSAGE);
//		printer.print(TYPE_A_WORD);
	}

}