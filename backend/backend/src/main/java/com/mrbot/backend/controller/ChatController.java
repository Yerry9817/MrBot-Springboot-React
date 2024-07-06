package com.mrbot.backend.controller;


import com.mrbot.backend.DTO.ChatDTO;
import com.mrbot.backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bot/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;


    @PostMapping
    public ResponseEntity<String> chat(@RequestBody ChatDTO input){
        try{
            return chatService.replyMesage(input);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
        }
    }
}
