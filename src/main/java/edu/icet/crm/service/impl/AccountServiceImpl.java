package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Account;
import edu.icet.crm.dto.Appointment;
import edu.icet.crm.entity.AccountEntity;
import edu.icet.crm.repository.AccountRepository;
import edu.icet.crm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Account> getAll() {
        List<Account> accountArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            accountArrayList.add(mapper.map(entity, Account.class));
        });
        return accountArrayList;
    }

    @Override
    public void addAccount(Account account) {
        repository.save(mapper.map(account, AccountEntity.class));
    }


}
