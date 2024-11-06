package edu.icet.crm.service.impl;

import edu.icet.crm.dto.Account;
import edu.icet.crm.entity.AccountEntity;
import edu.icet.crm.entity.AppointmentEntity;
import edu.icet.crm.repository.AccountRepository;
import edu.icet.crm.repository.AppointmentRepository;
import edu.icet.crm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Account> getAll() {
        return List.of();
    }

    @Override
    public void addAccount(Account account) {
        repository.save(mapper.map(account, AccountEntity.class));
    }

    @Override
    public Boolean validateLogin(Account login) {
        System.out.println(login.toString());
        //log.info(login.toString());
        return repository.existsByEmailAndPassword(login.getEmail(), login.getPassword());
    }
}
