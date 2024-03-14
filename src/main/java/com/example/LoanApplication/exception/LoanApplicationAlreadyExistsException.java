package com.example.LoanApplication.exception;

public class LoanApplicationAlreadyExistsException extends Exception {
    public LoanApplicationAlreadyExistsException(String msg){
        super(msg);
    }
}
