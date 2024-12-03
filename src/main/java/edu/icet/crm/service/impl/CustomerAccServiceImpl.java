package edu.icet.crm.service.impl;

import edu.icet.crm.dto.CustomerAcc;
import edu.icet.crm.entity.CustomerAccEntity;
import edu.icet.crm.repository.CustomerAccRepository;
import edu.icet.crm.service.CustomerAccService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerAccServiceImpl implements CustomerAccService {

    private final CustomerAccRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<CustomerAcc> getAll() {
        List<CustomerAcc> customerAccArrayList = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            customerAccArrayList.add(mapper.map(entity, CustomerAcc.class));
        });
        return customerAccArrayList;
    }

    @Override
    public void addCustomerAcc(CustomerAcc customerAcc) {
        repository.save(mapper.map(customerAcc, CustomerAccEntity.class));
    }

    @Override
    public void updateCustomerAcc(CustomerAcc customerAcc) {
        repository.save(mapper.map(customerAcc, CustomerAccEntity.class));
    }

    @Override
    public void deleteCustomerAccById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public CustomerAcc searchCustomerAccById(Integer id) {
        return mapper.map(repository.findById(id), CustomerAcc.class);
    }
}
