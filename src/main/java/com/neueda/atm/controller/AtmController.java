package com.neueda.atm.controller;

import com.neueda.atm.dto.Withdraw;
import com.neueda.atm.service.AtmService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
public class AtmController {

    @Autowired
    private AtmService atmService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Operation(summary = "withdraw", tags = "withdrawMoney")
    @ApiResponse(responseCode = "200", description = "Withdraw Money")
    @PostMapping("withdraw")
    public String withDraw(@RequestBody Withdraw withdraw) {
        return atmService.withDraw(withdraw);
    }
}
