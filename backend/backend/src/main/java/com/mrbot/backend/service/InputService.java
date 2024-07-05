package com.mrbot.backend.service;

import com.mrbot.backend.DTO.AssignDTO;
import com.mrbot.backend.DTO.InputDTO;
import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.repository.InputRepository;
import com.mrbot.backend.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    private InputRepository inputRepository;
    @Autowired
    private ResponseRepository responseRepository;

    public List<Input> findInputs() {return inputRepository.findAll();}

    public Optional<Input> findByContent(String content) {
        return inputRepository.findByContent(content);
    }

    public Input findById(Long id) {return inputRepository.findById(id).orElse(null);}

    public Response findResponsesByInputContent(String inputContent) {return inputRepository.findResponsesByInputContent(inputContent);}

    public Input save(InputDTO inputDTO) throws Exception {
            Optional<Input> inputExist = findByContent(inputDTO.getInputContent());
            if(inputExist.isEmpty()){
                Input newInput = new Input();
                newInput.setContent(inputDTO.getInputContent());
                return inputRepository.save(newInput);
            }else{
                throw new Exception("This input already exists");
            }
    }
}
