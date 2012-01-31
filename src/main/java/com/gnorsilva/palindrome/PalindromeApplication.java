package com.gnorsilva.palindrome;

import java.io.PrintWriter;

public class PalindromeApplication {

    private Printer printer;
    private PalindromeDetector detector;

    public PalindromeApplication(Printer printer, PalindromeDetector detector) {
        this.printer = printer;
        this.detector = detector;
    }

    public void isPalindrome(String string) {
        boolean result = detector.isPalindrome(string);
        String message = String.valueOf(result);
        printer.print(message);
    }

}