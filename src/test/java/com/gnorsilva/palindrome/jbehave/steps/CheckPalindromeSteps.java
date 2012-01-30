package com.gnorsilva.palindrome.jbehave.steps;

import com.gnorsilva.palindrome.PalindromeApplication;
import org.jbehave.core.annotations.*;

import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckPalindromeSteps {

	private PrintWriter printer;
	private PalindromeApplication app;

	@BeforeStory
	public void beforeStoryDo() {
		printer = mock(PrintWriter.class);
	}
	
	@Given("we run the palindrome application")
	public void givenWeRunThePalindromeApplication() {
		app = new PalindromeApplication(printer);
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
