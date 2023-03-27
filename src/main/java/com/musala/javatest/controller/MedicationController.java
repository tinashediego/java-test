package com.musala.javatest.controller;

import com.musala.javatest.common.ApiResponse;
import com.musala.javatest.dto.MedicationDto;
import com.musala.javatest.entity.Medication;
import com.musala.javatest.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medication")
public class MedicationController {
    @Autowired
    MedicationService medicationService;
    @PostMapping
    public ResponseEntity<ApiResponse> createMedication(@RequestBody MedicationDto medicationDto) {
        medicationService.createMedication(medicationDto);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Medication has been added"), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MedicationDto>> getMedications() {
        List<MedicationDto> medications = medicationService.getAllMedications();
        return new ResponseEntity<>(medications, HttpStatus.OK);
    }
    @GetMapping("/{medicationId}")
    public Optional<Medication> oneMedication(@PathVariable("medicationId") long medicationId) {
        return medicationService.findOne(medicationId);
    }
    @PutMapping("/{medicationId}")
    public ResponseEntity<ApiResponse> updateMedication(@PathVariable("medicationId") long medicationId, @RequestBody MedicationDto medicationDto) {
        System.out.println("medication id " + medicationId);
        if (!medicationService.findById(medicationId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Medication does not exists"), HttpStatus.NOT_FOUND);
        }
        medicationService.editMedication(medicationDto, medicationId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Medication has been updated"), HttpStatus.OK);
    }
    @DeleteMapping("/{medicationId}")
    public ResponseEntity<ApiResponse> deleteMedication(@PathVariable("medicationId") long medicationId){
        medicationService.removeMedication(medicationId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Medication has been deleted"), HttpStatus.OK);
    }
}
