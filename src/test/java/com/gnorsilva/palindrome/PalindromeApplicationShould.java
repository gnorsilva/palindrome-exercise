package com.gnorsilva.palindrome;

import static com.gnorsilva.palindrome.PalindromeApplication.TYPE_A_WORD;
import static com.gnorsilva.palindrome.PalindromeApplication.WELCOME_MESSAGE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Console;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeApplicationShould {

	@Mock private Console console;
	@Mock private PrintWriter writer;
	private PalindromeApplication application;
	
	@Before
	public void initialise() {
		Console console;
		when(console.writer()).thenReturn(writer);
		application = new PalindromeApplication(console);
	}
	
	@Test public void
	display_welcome_message_when_it_starts() {
		application.start();
		
		verify(console).writer().println(WELCOME_MESSAGE);
	}
	
	@Test public void
	ask_user_to_type_a_word() {
		application.start();
		
//		verify(printWriter).print(TYPE_A_WORD);
	}
	
}
