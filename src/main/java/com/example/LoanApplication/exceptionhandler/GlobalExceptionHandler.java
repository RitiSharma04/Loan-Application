package com.example.LoanApplication.exceptionhandler;

import com.example.LoanApplication.exception.LoanApplicationAlreadyExistsException;
import com.example.LoanApplication.exception.LoanApplicationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoanApplicationAlreadyExistsException.class)
    public ResponseEntity<String> handleLoanApplicationAlreadyExistsException(LoanApplicationAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Loan application already exists: " + ex.getMessage());
    }

    @ExceptionHandler(LoanApplicationNotFoundException.class)
    public ResponseEntity<String> handleLoanApplicationNotFoundException(LoanApplicationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Loan application not found: " + ex.getMessage());
    }

}