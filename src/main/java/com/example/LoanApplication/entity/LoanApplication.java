package com.example.LoanApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LoanApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bankName;
    private double minLoanAmount;
    private double maxLoanAmount;
    private double minInterestRate;
    private int minCreditScore;
    private int termLength;
    private double processingFee;
    private String rating;
    private String status;

    public LoanApplication() {
        // No-arg constructor
    }

    public LoanApplication(int id, String bankName, double minLoanAmount, double maxLoanAmount, double minInterestRate, int minCreditScore, int termLength, double processingFee, String rating, String status) {
        this.id = id;
        this.bankName = bankName;
        this.minLoanAmount = minLoanAmount;
        this.maxLoanAmount = maxLoanAmount;
        this.minInterestRate = minInterestRate;
        this.minCreditScore = minCreditScore;
        this.termLength = termLength;
        this.processingFee = processingFee;
        this.rating = rating;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getMinLoanAmount() {
        return minLoanAmount;
    }

    public void setMinLoanAmount(double minLoanAmount) {
        this.minLoanAmount = minLoanAmount;
    }

    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public double getMinInterestRate() {
        return minInterestRate;
    }

    public void setMinInterestRate(double minInterestRate) {
        this.minInterestRate = minInterestRate;
    }

    public int getMinCreditScore() {
        return minCreditScore;
    }

    public void setMinCreditScore(int minCreditScore) {
        this.minCreditScore = minCreditScore;
    }

    public int getTermLength() {
        return termLength;
    }

    public void setTermLength(int termLength) {
        this.termLength = termLength;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
