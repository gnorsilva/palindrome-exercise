package com.gnorsilva.palindrome;

import java.io.PrintWriter;

public class PalindromePrinter implements Printer {

    private final PrintWriter writer;

    public PalindromePrinter(PrintWriter writer) {
        this.writer = writer;
    }

    @Override
    public void print(String string) {
        writer.println(string);
    }
}
