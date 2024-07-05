package com.mrbot.backend.service;

import com.mrbot.backend.DTO.ResponsesDTO;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.repository.InputRepository;
import com.mrbot.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Optional<Response> findByContent(String content) { return responseRepository.findByContent(content);}

    public Response save(ResponsesDTO responseDTO) throws Exception {
        Optional<Response> responseExist = findByContent(responseDTO.getResponseContent());
        if(responseExist.isEmpty()){
            Response newResponse = new Response();
            newResponse.setContent(responseDTO.getResponseContent());
            return responseRepository.save(newResponse);
        }else{
            throw new Exception("This response already exists");
        }
    }
}
