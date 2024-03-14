package com.example.LoanApplication.exception;

public class LoanApplicationNotFoundException extends Exception {

    public LoanApplicationNotFoundException() {
        super("Loan application not found.");
    }

    public LoanApplicationNotFoundException(String message) {
        super(message);
    }
}
