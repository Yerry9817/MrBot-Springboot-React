package com.mrbot.backend.service;

import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.repository.InputRepository;
import com.mrbot.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class InputService {
    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private ResponseRepository responseRepository;

    public List<Input> findInputs() {
        return inputRepository.findAll();
    }

    public Input findById(Long id) {return inputRepository.findById(id).orElse(null);}

    public Input save(Input input) { return inputRepository.save(input);}

    public Input findByContent(String content) { return inputRepository.findByContent(content);}

    public Response findResponsesByInputContent(String inputContent) {
        return inputRepository.findResponsesByInputContent(inputContent);
    }
}
