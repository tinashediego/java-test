package com.musala.javatest.service;

import com.musala.javatest.entity.State;
import com.musala.javatest.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public void createState(State state) {
        stateRepository.save(state);
    }
    public List<State> listState() {
        return stateRepository.findAll();
    }

    public boolean findById(Long stateId) {
        return stateRepository.findById(stateId).isPresent();
    }

}
