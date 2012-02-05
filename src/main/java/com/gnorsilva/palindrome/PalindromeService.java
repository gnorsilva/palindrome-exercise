package com.gnorsilva.palindrome;

public class PalindromeService {

    private static final int MINIMUM_PALINDROME_LENGTH = 3;

    public boolean isPalindrome(String string) {
    	return (string.length() >= MINIMUM_PALINDROME_LENGTH)
    				? checkForPalindrome(string)
    				: false;
    }

    private boolean checkForPalindrome(String string) {
        String sanitized = removeIrregularCharacters(string);
        String reversed = reverse(sanitized);
        return sanitized.equalsIgnoreCase(reversed);
    }

    private String reverse(String sanitized) {
        return new StringBuffer(sanitized).reverse().toString();
    }

    private String removeIrregularCharacters(String string) {
        return string.replaceAll("\\W|_", "");
    }
}