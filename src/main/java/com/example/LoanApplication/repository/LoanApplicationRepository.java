package com.example.LoanApplication.repository;

import com.example.LoanApplication.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication,Integer> {
    // You can define custom query methods here if needed
}
