package com.gnorsilva.palindrome;

public class PalindromeService {

    private static final int MINIMUM_PALINDROME_LENGTH = 3;
	private PersistenceService persistenceService;

    public PalindromeService(PersistenceService persistenceService) {
    	this.persistenceService = persistenceService;
	}

	public boolean isPalindrome(String text) {
		if (persistenceService.isKnownPalindrome(text)) {
			return true;
		}
		
    	return (text.length() >= MINIMUM_PALINDROME_LENGTH)
    				? checkForPalindrome(text)
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