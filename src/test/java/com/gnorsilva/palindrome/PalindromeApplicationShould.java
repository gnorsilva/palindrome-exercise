package com.gnorsilva.palindrome;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PalindromeApplicationShould {

    private Printer printer = mock(Printer.class);
    private PalindromeDetector detector = mock(PalindromeDetector.class);
    private PalindromeApplication app = new PalindromeApplication(printer, detector);
    private String pop = "pop";

    @Test
    public void test_if_a_string_is_a_palindrome() throws Exception {
        app.isPalindrome(pop);
        verify(detector).isPalindrome(pop);
    }

    @Test
    public void display_the_result_of_testing_a_palindrome() throws Exception {
        when(detector.isPalindrome(eq(pop))).thenReturn(true);
        app.isPalindrome(pop);
        String expectedMessage = String.valueOf(true);
        verify(printer).print(expectedMessage);
    }

} 
