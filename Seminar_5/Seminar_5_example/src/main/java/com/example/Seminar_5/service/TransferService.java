package com.example.Seminar_5.service;

import com.example.Seminar_5.exception.AccountNotFoundException;
import com.example.Seminar_5.model.Account;
import com.example.Seminar_5.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    public void transferMoney(long idSender, long idReceiver, BigDecimal amount){
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());
        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccount(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountsByName(name);
    }
}
