package com.gnorsilva.palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersistenceService {

	private List<String> knownPalindromes = new ArrayList<String>();

	public boolean isKnownPalindrome(String text) {
		for (String knownPalindrome : knownPalindromes) {
			if (knownPalindrome.equalsIgnoreCase(text)) {
				return true;
			}
		}
		return false;
	}

	public void setKnownPalindromes(String... knownPalindromes) {
		this.knownPalindromes = Arrays.asList(knownPalindromes);
	}

}
