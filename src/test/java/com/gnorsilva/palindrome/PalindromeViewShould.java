package com.gnorsilva.palindrome;

import static com.gnorsilva.palindrome.PalindromeView.IS_A_PALINDROME_MSG;
import static com.gnorsilva.palindrome.PalindromeView.NOT_A_PALINDROME_MSG;
import static com.gnorsilva.palindrome.PalindromeView.TYPE_ANY_TEXT;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeViewShould {

	@Mock PalindromatonConsole palindromatonConsole;
	private PalindromeView view;
	
	@Before 
	public void initialise() {
		view = new PalindromeView(palindromatonConsole);
	}
	
	@Test public void
	display_message_asking_user_for_some_text() {
		view.askUserForText();
		
		verify(palindromatonConsole).write(TYPE_ANY_TEXT);
	}
	
	@Test public void
	return_text_user_has_typed() {
		when(palindromatonConsole.readInput()).thenReturn("Madam");
		
		String userInput = view.askUserForText();
		
		verify(palindromatonConsole).readInput();
		assertThat(userInput, is("Madam"));
	}
	
	@Test public void
	inform_result_is_palindrome() {
		view.informResultIs(true);
		
		verify(palindromatonConsole).write(IS_A_PALINDROME_MSG);
	}
	
	@Test public void
	inform_result_is_not_palindrome() {
		view.informResultIs(false);
		
		verify(palindromatonConsole).write(NOT_A_PALINDROME_MSG);
	}
	
}
