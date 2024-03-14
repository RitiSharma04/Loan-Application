package com.example.LoanApplication.service;

import com.example.LoanApplication.entity.LoanApplication;
import com.example.LoanApplication.exception.LoanApplicationAlreadyExistsException;
import com.example.LoanApplication.exception.LoanApplicationNotFoundException;

public interface LoanApplicationService {
    LoanApplication saveLoanApplication(LoanApplication loanApplication) throws LoanApplicationAlreadyExistsException;
    LoanApplication approveLoanApplication(int loanId) throws LoanApplicationNotFoundException;
    LoanApplication rejectLoanApplication(int loanId) throws LoanApplicationNotFoundException;
}
