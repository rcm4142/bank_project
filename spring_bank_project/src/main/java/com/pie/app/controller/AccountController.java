package com.pie.app.controller;

import com.pie.app.model.AccountDTO;
import com.pie.app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api")
public class AccountController {
    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService=accountService;
    }

    @GetMapping(value="/getAccountById/{accountId}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable("accountId") String accountId ){
        return new ResponseEntity<AccountDTO>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER_ROLE')")
    @PostMapping(value="/openAccount")
    public ResponseEntity<AccountDTO> openAccount(@RequestBody AccountDTO dto)
    {
        return new ResponseEntity<AccountDTO>(accountService.openAccount(dto),HttpStatus.CREATED);
    }
}
