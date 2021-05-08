package com.neueda.atm.service;

import com.neueda.atm.dto.Withdraw;
import com.neueda.atm.entity.ATM;
import com.neueda.atm.entity.Account;
import com.neueda.atm.entity.Currency;
import com.neueda.atm.repository.AccountRepository;
import com.neueda.atm.repository.AtmRepository;
import com.neueda.atm.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AtmServiceImpl implements AtmService{

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private  AtmRepository atmRepository;


    public String withDraw(Withdraw withdraw) {
        Account account = null;
        account = accountRepository.findByAccountNumberAndPin(withdraw.getAccountNumber(),withdraw.getPIN());
       int remaining = 0;
       String errMsg="Successfully withdrawn amount";
       int withdrawAmount = withdraw.getAmount();
       ATM atm = atmRepository.findAll().get(0);
       int atmTotalAmount =atm.getTotalAmount();
       if(atmTotalAmount >=withdrawAmount) {
           if (account != null) {
               if (withdrawAmount % 5 == 0) {
                   if (account.getOpeningBalance() >= withdrawAmount) {
                       remaining = account.getOpeningBalance() - withdrawAmount;
                       account.setOpeningBalance(remaining);
                       List<Currency> currencies = currencyRepository.getCurrency();
                       if (currencies != null) {
                           Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                           for (int i = 0; i < currencies.size(); i++) {
                               Currency cur = currencies.get(i);
                               int curAmount = cur.getAmount();
                               int curCount = cur.getCount();

                               int units = 0;
                               if (curAmount <= withdrawAmount) {

                                   units = withdrawAmount / curAmount;
                                   if (units > curCount) {
                                       units = curCount;
                                   }
                                   withdrawAmount = withdrawAmount - (units * curAmount);
                                   cur.setCount(curCount-units);
                                   currencyRepository.save(cur);
                                   accountRepository.save(account);
                                   atm.setTotalAmount(atmTotalAmount-withdraw.getAmount());
                                   atmRepository.save(atm);
                                   map.put(curAmount, units);
                               }

                           }
                       }

                   }
               } else {
                   errMsg = "Enter the amount multiples of 5 only";
               }
           } else {
               errMsg = "Invalid Account Number or PIN";
           }
       }
       else {
           errMsg = "Insufficient funds in ATM";
       }
        return errMsg;
    }
}
