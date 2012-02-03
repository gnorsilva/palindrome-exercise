package com.gnorsilva.palindrome.jbehave.steps;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.gnorsilva.palindrome.ApplicationView;
import com.gnorsilva.palindrome.PalindromeApplication;
import com.gnorsilva.palindrome.PalindromeService;

public class ApplicationLifecyleSteps {

	private static final String NOT_A_PALINDROME = "NOT_A_PALINDROME";
	private ApplicationView applicationView = mock(ApplicationView.class);
	private PalindromeService palindromeService = mock(PalindromeService.class);
	private PalindromeApplication app;
	
	@BeforeStory
	public void initialise() {
		when(applicationView.askUserForText()).thenReturn(NOT_A_PALINDROME);
		when(palindromeService.isPalindrome(NOT_A_PALINDROME)).thenReturn(false);
		app = new PalindromeApplication(applicationView, palindromeService);
	}
	
	@Given("we're using the Palindromaton")
	public void givenWeAreUsingThePalindromaton() {
		app.start();
	}

	@When("it asks us for some text")
	public void whenItAsksUsForSomeText() {
		verify(applicationView).askUserForText();
		verify(palindromeService).isPalindrome(NOT_A_PALINDROME);
	}

	@Then("we should be told if the text is a palindrome")
	public void then_we_should_be_told_if_the_text_is_a_palindrome() {
		verify(applicationView).informResultIs(false);
	}

}
