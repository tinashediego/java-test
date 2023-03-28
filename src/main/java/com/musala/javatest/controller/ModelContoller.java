package com.musala.javatest.controller;

import com.musala.javatest.common.ApiResponse;
import com.musala.javatest.entity.Model;
import com.musala.javatest.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelContoller {
    @Autowired
    ModelService modelService;
    @PostMapping
    public ResponseEntity<ApiResponse> createModel(@RequestBody Model model) {
        modelService.createModel(model);
        return new ResponseEntity<>(new ApiResponse(true, "a new model created"), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Model> listModel() {
        return modelService.listModel();
    }
}
