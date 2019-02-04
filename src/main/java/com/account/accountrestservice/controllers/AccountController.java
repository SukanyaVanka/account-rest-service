package com.account.accountrestservice.controllers;

import com.account.accountrestservice.models.Account;
import com.account.accountrestservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @RequestMapping(value= "/account/{id}",method = RequestMethod.GET)
    public Account getAccount(@PathVariable("id") Integer accountId){
        return accountService.getAccount(accountId);
    }

    @RequestMapping(value = "/account",method = RequestMethod.DELETE)
    public  void deleteAccount(@RequestBody Account account){
        accountService.deleteAccount(account.getAccountId());
    }

    @RequestMapping(value = "/account",method = RequestMethod.PUT)
    public Account updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }
}
