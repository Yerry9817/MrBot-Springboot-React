package com.mrbot.backend.service;

import com.mrbot.backend.DTO.ChatDTO;
import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatService {
    @Autowired
    ResponseService responseService;

    @Autowired
    InputService inputService;


    public ResponseEntity<String> replyMesage(ChatDTO input) throws Exception {
        String message = input.getMessage();
        if(!message.isEmpty()){
            Optional<Input> InputExists = inputService.findByContent(message);
            if(InputExists.isPresent()){
                Response response = inputService.findResponsesByInputContent(message);
                System.out.println(response);
                return ResponseEntity.ok(response.getContent());
            }
        }
        throw new Exception("Sorry, i didnt understand your question");
    }
}
