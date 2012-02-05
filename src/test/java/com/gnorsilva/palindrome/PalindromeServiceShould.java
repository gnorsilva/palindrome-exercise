package com.gnorsilva.palindrome;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeServiceShould {

	private PalindromeService palindromeService;
    @Mock private PersistenceService persistenceService;
    
    @Before
    public void initialise() {
    	when(persistenceService.isKnownPalindrome(anyString())).thenReturn(false);
    	palindromeService = new PalindromeService(persistenceService);
    }
    
    @Test public void
    check_if_text_is_a_known_palindrome() {
    	boolean result = palindromeService.isPalindrome("Not a palindrome");
    	
    	verify(persistenceService).isKnownPalindrome("Not a palindrome");
    	
    	assertThat(result, is(false));
    }
    
    @Test public void
    return_true_if_text_is_a_known_palindrome() {
    	when(persistenceService.isKnownPalindrome("KNOWN_PALINDROME")).thenReturn(true);
    	
    	boolean result = palindromeService.isPalindrome("KNOWN_PALINDROME");
    	
    	assertThat(result, is(true));
    }
    
    @Test
    public void not_confirm_a_single_letter_as_a_palindrome() {
        assertThat("x", isNotAPalindrome());
    }

    @Test
    public void not_confirm_two_identical_letters_as_a_palindrome() {
        assertThat("xx", isNotAPalindrome());
    }

    @Test
    public void confirm_pop_as_a_palindrome() {
        assertThat("pop", isAPalindrome());
    }

    @Test
    public void not_confirm_goncalo_as_a_palindrome() {
        assertThat("gonçalo", isNotAPalindrome());
    }

    @Test
    public void confirm_palindromes_with_upper_case_letters() {
        assertThat("Malayalam", isAPalindrome());
    }

    @Test
    public void confirm_sentences_as_palindromes() {
        assertThat("Sator Arepo Tenet Opera Rotas", isAPalindrome());
    }

    @Test
    public void confirm_irregular_spaced_sentences_as_palindromes() {
        assertThat("Ten animals I slam in a net", isAPalindrome());
    }

    @Test
    public void confirm_sentences_with_punctuation_as_palindromes() {
        assertThat("Doc, note, I dissent. A fast never prevents a fatness. I diet on cod.", isAPalindrome());
    }

    @Test
    public void confirm_sentences_with_underscores_as_palindromes() {
        assertThat("Dammit_I'm_mad", isAPalindrome());
    }

    @Test
    public void not_confirm_non_palindrome_sentences_as_palindromes() {
        assertThat("not a palindrome", isNotAPalindrome());
    }

    @Test
    public void confirm_palindrome_numbers() {
        assertThat("121", isAPalindrome());
    }

    @Test
    public void confirm_palindrome_numbers_with_punctuation() {
        assertThat("11/22/11", isAPalindrome());
    }

    private Matcher<String> isAPalindrome() {
        return new IsAPalindrome();
    }

    private class IsAPalindrome extends BaseMatcher<String> {
        @Override
        public boolean matches(Object o) {
            return palindromeService.isPalindrome(o.toString());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("to be a palindrome");
        }
    }

    private Matcher<String> isNotAPalindrome() {
        return new IsNotAPalindrome();
    }

    private class IsNotAPalindrome extends BaseMatcher<String> {
        @Override
        public boolean matches(Object o) {
            return !palindromeService.isPalindrome(o.toString());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("not to be a palindrome");
        }
    }
}