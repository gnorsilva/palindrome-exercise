package com.gnorsilva.palindrome.jbehave.steps;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.gnorsilva.palindrome.PalindromeService;

public class CheckPalindromeSteps {

	private String userInput;
	private PalindromeService palindromeService;
	private boolean result;

	@BeforeStory
	public void beforeStoryDo() {
		this.palindromeService = new PalindromeService();
	}
	
	@Given("we type a <string>")
	public void given_we_type_a(@Named("string") String string) {
		this.userInput = string;
	}

	@When("we ask Palindromaton to verify it")
	public void when_we_ask_Palindromaton_to_verify_id() {
		this.result = palindromeService.isPalindrome(userInput);
	}

	@Then("we should be notified if it <isPalindrome>")
	public void then_we_should_be_notified_if_it(@Named("isPalindrome") Boolean isPalindrome){
		assertThat(result, is(isPalindrome));
	}

}
