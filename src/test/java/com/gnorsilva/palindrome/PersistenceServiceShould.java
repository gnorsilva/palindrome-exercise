package com.gnorsilva.palindrome;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PersistenceServiceShould {
	
	private static final String NOT_A_KNOWN_PALINDROME = "NOT_A_PALINDROME";
	private PersistenceService persistenceService;

	@Before
	public void initialise() {
		persistenceService = new PersistenceService();
	}
	
	@Test public void
	indicate_if_text_is_not_a_known_palindrome() {
		assertFalse(persistenceService.isKnownPalindrome(NOT_A_KNOWN_PALINDROME));
	}

	@Test public void
	indicate_if_text_is_a_known_palindrome() {
		persistenceService.setKnownPalindromes("Madam", "Amma");
		
		assertTrue(persistenceService.isKnownPalindrome("Madam"));
	}
	
	@Test public void
	indicate_if_text_is_a_known_palindrome_when_case_is_different() {
		persistenceService.setKnownPalindromes("Madam", "Amma");
		
		assertTrue(persistenceService.isKnownPalindrome("aMMA"));
	}
	
}
