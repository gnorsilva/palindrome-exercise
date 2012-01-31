package com.gnorsilva.palindrome.jbehave.steps;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;
import java.io.PrintWriter;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.gnorsilva.palindrome.PalindromeApplication;

public class CheckPalindromeSteps {

	private Console console;
	private PrintWriter printer;
	private PalindromeApplication app;

	@BeforeStory
	public void beforeStoryDo() {
		console = mock(Console.class);
		printer = mock(PrintWriter.class);
		when(console.writer()).thenReturn(printer);
	}
	
	@Given("we run the palindrome application")
	public void givenWeRunThePalindromeApplication() {
		app = new PalindromeApplication(console);
	}

	@When("we ask if a <string> is a palindrome")
	public void whenWeAskIfAStringIsAPalindrome(@Named("string") String string){
		app.isPalindrome(string);
	}

	@Then("application should display <isPalindrome>")
	public void thenTheApplicationShouldDisplay(@Named("isPalindrome") Boolean isPalindrome){
		verify(printer).println(isPalindrome);
	}

}
