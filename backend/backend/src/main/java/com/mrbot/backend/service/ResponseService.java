package com.mrbot.backend.service;

import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.repository.InputRepository;
import com.mrbot.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {
    @Autowired
    private InputRepository inputRepository;

    @Autowired
    private ResponseRepository responseRepository;

    public Response findById(Long id) {
        return responseRepository.findById(id).orElse(null);
    }

    public List<Response> findResponses(){
        return responseRepository.findAll();
    }

    public Response findByContent(String content) { return responseRepository.findByContent(content);}

    public Response save(Response response) {
        return responseRepository.save(response);
    }
}
