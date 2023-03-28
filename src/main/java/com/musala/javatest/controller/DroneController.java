package com.musala.javatest.controller;

import com.musala.javatest.common.ApiResponse;
import com.musala.javatest.dto.DroneDto;
import com.musala.javatest.entity.Drone;
import com.musala.javatest.entity.Model;
import com.musala.javatest.entity.State;
import com.musala.javatest.repository.ModelRepository;
import com.musala.javatest.repository.StateRepository;
import com.musala.javatest.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drone")
public class DroneController {
    @Autowired
    DroneService droneService;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private ModelRepository modelRepository;

    @PostMapping
    public ResponseEntity<ApiResponse> createDrone(@RequestBody DroneDto droneDto) {
        Optional<State> optionalState = stateRepository.findById(droneDto.getStateId());
        Optional<Model> optionalModel = modelRepository.findById(droneDto.getModelId());
        if (!optionalState.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "State does not exists"), HttpStatus.BAD_REQUEST);
        }

        if (!optionalModel.isPresent()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Model does not exists"), HttpStatus.BAD_REQUEST);
        }
        droneService.createDrone(droneDto, optionalModel.get(), optionalState.get());
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Drone has been added"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DroneDto>> getDrones() {
        List<DroneDto> drones = droneService.getAllDrones();
        return new ResponseEntity<>(drones, HttpStatus.OK);
    }
    @GetMapping("/{droneId}")
    public Optional<Drone> oneDrone(@PathVariable("droneId") long droneId) {
        return droneService.findOne(droneId);
    }
    @PutMapping("/{droneId}")
    public ResponseEntity<ApiResponse> updateDrone(@PathVariable("droneId") long droneId, @RequestBody DroneDto droneDto) {
        System.out.println("drone id " + droneId);
        if (!droneService.findById(droneId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Drone does not exists"), HttpStatus.NOT_FOUND);
        }
        droneService.editDrone(droneDto, droneId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Drone has been updated"), HttpStatus.OK);
    }
    @DeleteMapping("/{droneId}")
    public ResponseEntity<ApiResponse> deleteDrone(@PathVariable("droneId") long droneId){
        droneService.removeDrone(droneId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Drone has been deleted"), HttpStatus.OK);
    }
}
