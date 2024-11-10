package edu.icet.crm.controller;

import edu.icet.crm.dto.VehicleAcc;
import edu.icet.crm.service.VehicleAccService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/VehicleAcc")
@RequiredArgsConstructor
public class VehicleAccController {

    final VehicleAccService service;

    @GetMapping("/get-all")
    public List<VehicleAcc> getVehicleAcc(){
       return service.getAll();
    }

    @PostMapping("/add-vehicleAcc")
    @ResponseStatus(HttpStatus.CREATED)
    public void addVehicleAcc(@RequestBody VehicleAcc vehicleAcc){
        service.addVehicleAcc(vehicleAcc);
    }

    @PutMapping("/update-vehicleAcc")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateVehicleAcc(@RequestBody VehicleAcc vehicleAcc){
        service.updateVehicleAcc(vehicleAcc);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void deleteVehicleAccById(@PathVariable Integer id){
        service.deleteVehicleAccById(id);
    }

    @GetMapping("/search-by-id/{id}")
    public VehicleAcc searchVehicleAccById(@PathVariable Integer id){
        return service.searchVehicleAccById(id);
    }

}
