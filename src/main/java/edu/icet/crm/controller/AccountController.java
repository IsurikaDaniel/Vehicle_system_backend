package edu.icet.crm.controller;

import edu.icet.crm.dto.Account;
import edu.icet.crm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/Account")
@RequiredArgsConstructor
public class AccountController {


    final AccountService service;

    @GetMapping("/get-all")
    public List<Account> getAccount(){
        return service.getAll();
    }

    @PostMapping("/add-account")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAccount(@RequestBody Account account){
        service.addAccount(account);
    }


}
