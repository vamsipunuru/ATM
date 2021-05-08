package com.neueda.atm.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("Account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private Long AccountNumber;
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
