package com.mrbot.backend.service;

import com.mrbot.backend.DTO.AssignDTO;
import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.repository.InputRepository;
import com.mrbot.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssignService {
    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private ResponseRepository responseRepository;

    public void assign(AssignDTO data) throws Exception {
        Optional<Input> input = inputRepository.findByContent(data.getInput());
        Optional<Response> response = responseRepository.findByContent(data.getResponse());

        if (input.isEmpty()) {
            throw new Exception("La entrada no existe");
        }
        if (response.isEmpty()) {
            throw new Exception("La respuesta no existe");
        }

        if (!input.get().getResponses().contains(response.get())) {
            input.get().getResponses().add(response.get());
            inputRepository.save(input.get());
        }
    }
}