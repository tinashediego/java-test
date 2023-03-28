package com.musala.javatest.service;

import com.musala.javatest.dto.DroneDto;
import com.musala.javatest.entity.Drone;
import com.musala.javatest.entity.Model;
import com.musala.javatest.entity.State;
import com.musala.javatest.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DroneService {
    @Autowired
    DroneRepository droneRepository;

    public void createDrone(DroneDto droneDto, Model model, State state) {
        Drone drone = new Drone();
        drone.setSerialNumber(droneDto.getSerialNumber());
        drone.setModel(model);
        drone.setState(state);
        drone.setWeight(droneDto.getWeight());
        drone.setBatteryCapacity(droneDto.getBatteryCapacity());
        drone.setModel(model);
        drone.setState(state);
        droneRepository.save(drone);
    }

    public DroneDto getDroneDto(Drone drone) {
        DroneDto droneDto = new DroneDto();
        //productDto.setCategoryId(product.getCategory().getId());
        droneDto.setStateId(drone.getState().getId());
        droneDto.setSerialNumber(drone.getSerialNumber());
        droneDto.setModelId(drone.getModel().getId());
        droneDto.setWeight(drone.getWeight());
        droneDto.setBatteryCapacity(drone.getBatteryCapacity());
        droneDto.setId(drone.getId());
        droneDto.setModelId(drone.getModel().getId());
        droneDto.setStateId(drone.getState().getId());
        return droneDto;
    }
    public List<DroneDto> getAllDrones() {
        List<Drone> allDrones = droneRepository.findAll();
        List<DroneDto> droneDtos = new ArrayList<>();
        for(Drone drone: allDrones) {
            droneDtos.add(getDroneDto(drone));
        }
        return droneDtos;
    }
    public Optional<Drone> findOne(long droneId) {
        return droneRepository.findById(droneId);
    }
    public void editDrone(DroneDto droneDto, Long droneId) {
        Drone drone = droneRepository.getById(droneId);
        drone.setSerialNumber(droneDto.getSerialNumber());
        drone.setWeight(droneDto.getWeight());
        drone.setBatteryCapacity(droneDto.getBatteryCapacity());
        droneRepository.save(drone);
    }
    public boolean findById(long droneId) {
        return droneRepository.findById(droneId).isPresent();
    }
    public void removeDrone(long droneId){
        droneRepository.deleteById(droneId);
    }
}
