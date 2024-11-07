package edu.icet.crm.service;
import edu.icet.crm.dto.CustomerAcc;

import java.util.List;

public interface CustomerAccService {

    List<CustomerAcc> getAll();
    void addCustomerAcc(CustomerAcc customerAcc);
    void updateCustomerAcc(CustomerAcc customerAcc);
    void deleteCustomerAccById(Integer id);
    CustomerAcc searchCustomerAccById(Integer id);

}
