package com.musala.javatest.service;

import com.musala.javatest.entity.Model;
import com.musala.javatest.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModelService {
    @Autowired
    ModelRepository modelRepository;

    public void createModel(Model model) {
        modelRepository.save(model);
    }
    public List<Model> listModel() {
        return modelRepository.findAll();
    }
    public boolean findById(Long modelId) {
        return modelRepository.findById(modelId).isPresent();
    }

}
