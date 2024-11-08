package edu.icet.crm.service.impl;

import edu.icet.crm.dto.VehicleAcc;
import edu.icet.crm.entity.VehicleAccEntity;
import edu.icet.crm.repository.VehicleAccRepository;
import edu.icet.crm.service.VehicleAccService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleAccServiceImpl implements VehicleAccService {

    private final VehicleAccRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<VehicleAcc> getAll() {
        List<VehicleAcc> vehicleAccArrayList = new ArrayList<>();
        repository.findAll().forEach(entity ->{
            vehicleAccArrayList.add(mapper.map(entity, VehicleAcc.class));
        });
        return vehicleAccArrayList;
    }

    @Override
    public void addVehicleAcc(VehicleAcc vehicleAcc) {
        repository.save(mapper.map(vehicleAcc, VehicleAccEntity.class));
    }

    @Override
    public void updateVehicleAcc(VehicleAcc vehicleAcc) {
        repository.save(mapper.map(vehicleAcc, VehicleAccEntity.class));
    }

    @Override
    public void deleteVehicleAccById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public VehicleAcc searchVehicleAccById(Integer id) {
        return mapper.map(repository.findById(id), VehicleAcc.class);
    }
}
