package com.neueda.atm;

import com.neueda.atm.dto.Withdraw;
import com.neueda.atm.entity.ATM;
import com.neueda.atm.entity.Account;
import com.neueda.atm.entity.Currency;
import com.neueda.atm.repository.AccountRepository;
import com.neueda.atm.repository.AtmRepository;
import com.neueda.atm.repository.CurrencyRepository;
import com.neueda.atm.service.AtmService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AtmServiceImplTest  {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private  AtmRepository atmRepository;
    @Autowired
    private AtmService atmService;
    @Before
    public void setUp()  {
        Account ac =new Account();
        ac.setAccountNumber(123456789l);
        ac.setPIN(1234);
        ac.setOpeningBalance(800);
        ac.setOverDraft(230);
        accountRepository.save(ac);
        ATM atm =new ATM();
        atm.setId(1);
        atm.setTotalAmount(1500);
        atmRepository.save(atm);
        Currency cur1 =new Currency();
        cur1.setId(1);
        cur1.setAmount(50);
        cur1.setCount(10);
        currencyRepository.save(cur1);
        Currency cur2 =new Currency();
        cur2.setId(2);
        cur2.setAmount(20);
        cur2.setCount(30);
        currencyRepository.save(cur2);
        Currency cur3 =new Currency();
        cur3.setId(3);
        cur3.setAmount(10);
        cur3.setCount(30);
        currencyRepository.save(cur3);
        Currency cur4 =new Currency();
        cur4.setId(4);
        cur4.setAmount(5);
        cur4.setCount(20);
        currencyRepository.save(cur4);
    }
    @Test
    public void testWithDraw() {
        Withdraw withdraw = new Withdraw();
        withdraw.setAccountNumber(123456789l);
        withdraw.setPIN(1234);
        withdraw.setAmount(575);
        String msg ="Successfully withdrawn amount";

        String entityMsg= atmService.withDraw(withdraw);
        assertNotNull(withdraw);
        assertEquals(msg,entityMsg);
    }

}
