package com.example.LoanApplication.controller;

import com.example.LoanApplication.entity.LoanApplication;
import com.example.LoanApplication.exception.LoanApplicationAlreadyExistsException;
import com.example.LoanApplication.exception.LoanApplicationNotFoundException;
import com.example.LoanApplication.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping("/applyloan")
    public ResponseEntity<LoanApplication> applyLoan(@RequestBody LoanApplication loanApplication) throws LoanApplicationAlreadyExistsException {
        LoanApplication savedLoanApplication = loanApplicationService.saveLoanApplication(loanApplication);
        return new ResponseEntity<>(savedLoanApplication, HttpStatus.CREATED);
    }

    @PostMapping("/approveloan/{loanId}")
    public ResponseEntity<LoanApplication> approveLoan(@PathVariable int loanId) throws LoanApplicationNotFoundException {
        LoanApplication approvedLoanApplication = loanApplicationService.approveLoanApplication(loanId);
        return new ResponseEntity<>(approvedLoanApplication, HttpStatus.OK);
    }

    @PostMapping("/rejectloan/{loanId}")
    public ResponseEntity<LoanApplication> rejectLoan(@PathVariable int loanId) throws LoanApplicationNotFoundException {
        LoanApplication rejectedLoanApplication = loanApplicationService.rejectLoanApplication(loanId);
        return new ResponseEntity<>(rejectedLoanApplication, HttpStatus.OK);
    }
}
