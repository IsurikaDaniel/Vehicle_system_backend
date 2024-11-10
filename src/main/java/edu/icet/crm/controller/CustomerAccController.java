package edu.icet.crm.controller;

import edu.icet.crm.dto.CustomerAcc;
import edu.icet.crm.service.CustomerAccService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/CustomerAcc")
@RequiredArgsConstructor
public class CustomerAccController {

    final CustomerAccService service;

    @GetMapping("/get-all")
    public List<CustomerAcc> getCustomerAcc(){
        return service.getAll();
    }

    @PostMapping("/add-CustomerAcc")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomerAcc(@RequestBody CustomerAcc customerAcc){
        service.addCustomerAcc(customerAcc);
    }

    @GetMapping("/search-by-id/{id}")
    public  CustomerAcc searchCustomerAccById(@PathVariable Integer id){
       return service.searchCustomerAccById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void deleteCustomerAccById(@PathVariable Integer id){
        service.deleteCustomerAccById(id);
    }

    @PutMapping("/update-customerAcc")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomerAcc(@RequestBody CustomerAcc customerAcc){
        service.updateCustomerAcc(customerAcc);
    }
}
