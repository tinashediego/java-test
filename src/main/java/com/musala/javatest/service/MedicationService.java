package com.musala.javatest.service;

import com.musala.javatest.dto.MedicationDto;
import com.musala.javatest.entity.Medication;
import com.musala.javatest.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {
    @Autowired
    MedicationRepository medicationRepository;


    public void createMedication(MedicationDto medicationDto) {
        Medication medication = new Medication();
        medication.setName(medicationDto.getName());
        medication.setImageUrl(medicationDto.getImageUrl());
        medication.setCode(medicationDto.getCode());
        medication.setWeight(medicationDto.getWeight());
        medicationRepository.save(medication);
    }

    public MedicationDto getMedicationDto(Medication medication) {
        MedicationDto medicationDto = new MedicationDto();
        medicationDto.setImageUrl(medication.getImageUrl());
        medicationDto.setName(medication.getName());
        medicationDto.setCode(medication.getCode());
        medicationDto.setWeight(medication.getWeight());
        medicationDto.setId(medication.getId());
        return medicationDto;
    }
    public List<MedicationDto> getAllMedications() {
        List<Medication> allMedications = medicationRepository.findAll();
        List<MedicationDto> medicationDtos = new ArrayList<>();
        for(Medication medication: allMedications) {
            medicationDtos.add(getMedicationDto(medication));
        }
        return medicationDtos;
    }
    public Optional<Medication> findOne(long medicationId) {
        return medicationRepository.findById(medicationId);
    }
    public void editMedication(MedicationDto medicationDto, Long medicationId) {
        Medication medication = medicationRepository.getById(medicationId);
        medication.setName(medicationDto.getName());
        medication.setImageUrl(medicationDto.getImageUrl());
        medication.setCode(medicationDto.getCode());
        medication.setWeight(medicationDto.getWeight());
        medicationRepository.save(medication);
    }
    public boolean findById(long medicationId) {
        return medicationRepository.findById(medicationId).isPresent();
    }
    public void removeMedication(long medicationId){
        medicationRepository.deleteById(medicationId);
    }
}
