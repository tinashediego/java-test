package com.musala.javatest.controller;

import com.musala.javatest.common.ApiResponse;
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
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Medication medication) {
        medicationService.createMedication(medication);
        return new ResponseEntity<>(new ApiResponse(true, "New medication created"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public List<Medication> listCategory() {
        return medicationService.listMedication();
    }
    @GetMapping("/findById/{medicationId}")
    public Optional<Medication> oneCategory(@PathVariable("categoryId") long medicationId) {
        return medicationService.findOne(medicationId);
    }
    @PutMapping("/update/{medicationId}")
    public ResponseEntity<ApiResponse> updateMedication(@PathVariable("medicationId") long medicationId, @RequestBody Medication medication) {
        System.out.println("medication id " + medicationId);
        if (!medicationService.findById(medicationId)) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Medication does not exists"), HttpStatus.NOT_FOUND);
        }
        medicationService.editMedication(medicationId, medication);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Medication has been updated"), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<ApiResponse> deleteMedication(@PathVariable("medicationId") long medicationId){
        medicationService.removeMedication(medicationId);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Medication has been deleted"), HttpStatus.OK);
    }
}
