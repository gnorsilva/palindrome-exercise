package com.gnorsilva.palindrome;

import org.junit.Test;

import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PalindromePrinterShould {

    private final PrintWriter writer = mock(PrintWriter.class);
    private final Printer palindromePrinter = new PalindromePrinter(writer);

    @Test
    public void print_a_message_received_onto_a_new_line() throws Exception {
        String message = "A simple message";
        palindromePrinter.print(message);
        verify(writer).println(message);
    }

}
