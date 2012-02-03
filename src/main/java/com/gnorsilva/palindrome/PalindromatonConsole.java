package com.gnorsilva.palindrome;

import java.util.Scanner;

public class PalindromatonConsole {
	
	public void write(String text) {
		System.out.println(text);
	}
	
	public String readInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.next();
	}
}