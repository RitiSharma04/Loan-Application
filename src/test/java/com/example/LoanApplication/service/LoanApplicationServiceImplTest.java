package com.example.LoanApplication.service;

import com.example.LoanApplication.entity.LoanApplication;
import com.example.LoanApplication.exception.LoanApplicationAlreadyExistsException;
import com.example.LoanApplication.exception.LoanApplicationNotFoundException;
import com.example.LoanApplication.repository.LoanApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanApplicationServiceImplTest {

    @Mock
    private LoanApplicationRepository loanApplicationRepository;

    @InjectMocks
    private LoanApplicationServiceImpl loanApplicationService;
    @Mock
    LoanApplication loanApplication;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSaveLoanApplication() throws LoanApplicationAlreadyExistsException {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setId(1);
        loanApplication.setStatus("Pending");
        when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);

        LoanApplication savedLoanApplication = loanApplicationService.saveLoanApplication(loanApplication);
        assertEquals(loanApplication.getId(), savedLoanApplication.getId());
    }

    @Test
    void testSaveLoanApplication_AlreadyExists() {
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setId(1);
        loanApplication.setStatus("Pending");

        when(loanApplicationRepository.existsById(loanApplication.getId())).thenReturn(true);

        assertThrows(LoanApplicationAlreadyExistsException.class, () -> loanApplicationService.saveLoanApplication(loanApplication));
    }
    @Test
    void testApproveLoanApplication() throws LoanApplicationNotFoundException {
        int loanId = 1;
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setId(loanId);
        loanApplication.setStatus("Pending");

        when(loanApplicationRepository.findById(loanId)).thenReturn(Optional.of(loanApplication));
        when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);

        LoanApplication approvedLoanApplication = loanApplicationService.approveLoanApplication(loanId);
        assertEquals("Approved", approvedLoanApplication.getStatus());
    }


    @Test
    void testApproveLoanApplication_NotFound() {
        int loanId = 1;

        when(loanApplicationRepository.findById(loanId)).thenReturn(Optional.empty());

        assertThrows(LoanApplicationNotFoundException.class, () -> loanApplicationService.approveLoanApplication(loanId));
    }

    @Test
    void testRejectLoanApplication() throws LoanApplicationNotFoundException {
        int loanId = 1;
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setId(loanId);
        loanApplication.setStatus("Pending");

        when(loanApplicationRepository.findById(loanId)).thenReturn(Optional.of(loanApplication));
        when(loanApplicationRepository.save(loanApplication)).thenReturn(loanApplication);

        LoanApplication rejectedLoanApplication = loanApplicationService.rejectLoanApplication(loanId);

        assertEquals("Rejected", rejectedLoanApplication.getStatus());

        verify(loanApplicationRepository, times(1)).save(loanApplication);
    }


    @Test
    void testRejectLoanApplication_NotFound() {
        int loanId = 1;

        when(loanApplicationRepository.findById(loanId)).thenReturn(Optional.empty());

        assertThrows(LoanApplicationNotFoundException.class, () -> loanApplicationService.rejectLoanApplication(loanId));
    }
}
