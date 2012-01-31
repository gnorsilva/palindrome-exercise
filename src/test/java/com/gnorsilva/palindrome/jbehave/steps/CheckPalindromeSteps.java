package com.gnorsilva.palindrome.jbehave.steps;

import com.gnorsilva.palindrome.*;
import org.jbehave.core.annotations.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckPalindromeSteps {

	private Printer printer;
    private PalindromeDetector detector;
    private PalindromeApplication app;

	@Given("we run the palindrome application")
	public void givenWeRunThePalindromeApplication() {
        printer = mock(Printer.class);
        detector = new PalindromeService();
		app = new PalindromeApplication(printer, detector);
	}

	@When("we ask if a <string> is a palindrome")
	public void whenWeAskIfAStringIsAPalindrome(@Named("string") String string){
		app.isPalindrome(string);
	}

	@Then("application should display <isPalindrome>")
	public void thenTheApplicationShouldDisplay(@Named("isPalindrome") String isPalindrome){
		verify(printer).print(isPalindrome);
	}

}
