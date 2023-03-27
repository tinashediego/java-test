package com.musala.javatest.service;

import com.musala.javatest.entity.Medication;
import com.musala.javatest.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;

    public void createMedication(Medication medication) {
        medicationRepository.save(medication);
    }
    public List<Medication> listMedication() {
        return medicationRepository.findAll();
    }
    public Optional<Medication> findOne(long medicationId) {
        return medicationRepository.findById(medicationId);
    }
    public void editMedication(long medicationId, Medication updateMedication) {
        Medication medication = medicationRepository.getById(medicationId);
        medication.setName(updateMedication.getName());
        medication.setCode(updateMedication.getCode());
        medication.setWeight(updateMedication.getWeight());
        medication.setImageUrl(updateMedication.getImageUrl());
        medicationRepository.save(medication);
    }
    public boolean findById(long medicationId) {
        return medicationRepository.findById(medicationId).isPresent();
    }
    public void removeMedication(long medicationId){
        medicationRepository.deleteById(medicationId);
    }
}
