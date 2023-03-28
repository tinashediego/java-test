package com.musala.javatest.controller;

import com.musala.javatest.common.ApiResponse;
import com.musala.javatest.entity.State;
import com.musala.javatest.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    @Autowired
    StateService stateService;
    @PostMapping
    public ResponseEntity<ApiResponse> createState(@RequestBody State state) {
        stateService.createState(state);
        return new ResponseEntity<>(new ApiResponse(true, "a new state created"), HttpStatus.CREATED);
    }
    @GetMapping
    public List<State> listState() {
        return stateService.listState();
    }

}
