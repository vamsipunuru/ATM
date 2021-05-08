package com.neueda.atm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

public class Withdraw {
    private Long AccountNumber;
    private int PIN;
    private int Amount;

    public Withdraw(Long accountNumber, int PIN, int amount) {
        AccountNumber = accountNumber;
        this.PIN = PIN;
        Amount = amount;
    }

    public Withdraw() {

    }

    public Long getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        AccountNumber = accountNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
