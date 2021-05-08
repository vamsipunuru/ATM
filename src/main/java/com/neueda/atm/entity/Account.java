package com.neueda.atm.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
    @Id
    private Long AccountNumber;

    @Column(nullable = false)
    private int PIN;

    private int OpeningBalance;
    private int OverDraft;

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

    public int getOpeningBalance() {
        return OpeningBalance;
    }

    public void setOpeningBalance(int openingBalance) {
        OpeningBalance = openingBalance;
    }

    public int getOverDraft() {
        return OverDraft;
    }

    public void setOverDraft(int overDraft) {
        OverDraft = overDraft;
    }
}
