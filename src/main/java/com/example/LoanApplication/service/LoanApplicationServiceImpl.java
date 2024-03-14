package com.example.LoanApplication.service;

import com.example.LoanApplication.entity.LoanApplication;
import com.example.LoanApplication.exception.LoanApplicationAlreadyExistsException;
import com.example.LoanApplication.exception.LoanApplicationNotFoundException;
import com.example.LoanApplication.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Override
    public LoanApplication saveLoanApplication(LoanApplication loanApplication) throws LoanApplicationAlreadyExistsException {
        if (loanApplicationRepository.existsById(loanApplication.getId())) {
            throw new LoanApplicationAlreadyExistsException("Loan application already exists with ID: " + loanApplication.getId());
        }
        return loanApplicationRepository.save(loanApplication);
    }


    @Override
    public LoanApplication approveLoanApplication(int loanId) throws LoanApplicationNotFoundException {
        LoanApplication loanApplication = loanApplicationRepository.findById(loanId)
                .orElseThrow(() -> new LoanApplicationNotFoundException("Loan application not found with ID: " + loanId));

        loanApplication.setStatus("Approved");
        return loanApplicationRepository.save(loanApplication);
    }

    @Override
    public LoanApplication rejectLoanApplication(int loanId) throws LoanApplicationNotFoundException {
        LoanApplication loanApplication = loanApplicationRepository.findById(loanId)
                .orElseThrow(() -> new LoanApplicationNotFoundException("Loan application not found with ID: " + loanId));

        loanApplication.setStatus("Rejected");
        return loanApplicationRepository.save(loanApplication);
    }


}
