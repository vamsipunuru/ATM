package com.neueda.atm;

import antlr.PrintWriterWithSMAP;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.neueda.atm.controller.AtmController;
import com.neueda.atm.entity.ATM;
import com.neueda.atm.entity.Account;
import com.neueda.atm.dto.Withdraw;
import com.neueda.atm.entity.Currency;
import com.neueda.atm.repository.AccountRepository;
import com.neueda.atm.repository.AtmRepository;
import com.neueda.atm.repository.CurrencyRepository;
import com.neueda.atm.service.AtmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.anyString;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = AtmController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class AtmControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AtmService atmService;
    @MockBean
    private AccountRepository accountRepository;
    @MockBean
    private CurrencyRepository currencyRepository;
    @MockBean
    private AtmRepository atmRepository;
    private PrintWriterWithSMAP withdraw;
    private JacksonTester<Withdraw> withdrawJson;

    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void testWithdraw() throws Exception {

        Withdraw withdraw = new Withdraw();
        withdraw.setAccountNumber(123456789l);
        withdraw.setPIN(1234);
        withdraw.setAmount(575);
        String msg ="Success";
        String body = this.withdrawJson.write(withdraw).getJson();

        given(atmService.withDraw(any(Withdraw.class))).willReturn(msg);

        mvc.perform(post("/api/v1/withdraw").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk());
        verify(atmService, times(1)).withDraw(any(Withdraw.class));
        verifyNoMoreInteractions(atmService);
    }
}
