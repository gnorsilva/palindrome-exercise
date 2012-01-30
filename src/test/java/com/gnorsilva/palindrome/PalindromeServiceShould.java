package com.gnorsilva.palindrome;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PalindromeServiceShould {

    private final PalindromeDetector palindromeDetector = new PalindromeService();

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
            return palindromeDetector.isPalindrome(o.toString());
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
            return !palindromeDetector.isPalindrome(o.toString());
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("not to be a palindrome");
        }
    }
}