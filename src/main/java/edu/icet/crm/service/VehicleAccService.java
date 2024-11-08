package edu.icet.crm.service;

import edu.icet.crm.dto.VehicleAcc;

import java.util.List;

public interface VehicleAccService {
    List<VehicleAcc> getAll();
    void addVehicleAcc(VehicleAcc vehicleAcc);
    void updateVehicleAcc(VehicleAcc vehicleAcc);
    void deleteVehicleAccById(Integer id);
    VehicleAcc searchVehicleAccById(Integer id);
}
