package com.example.Seminar_5.controller;

import com.example.Seminar_5.model.Account;
import com.example.Seminar_5.model.dto.TransferRequest;
import com.example.Seminar_5.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {
    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount());
    }
    @GetMapping("/account")
    public Iterable<Account> getAccounts(){
        return transferService.getAllAccount();
    }
}
