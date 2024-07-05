package com.mrbot.backend.controller;

import com.mrbot.backend.DTO.AssignDTO;
import com.mrbot.backend.service.AssignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bot/assign")
public class AssignController {

    @Autowired
    AssignService assignService;


    @PostMapping
    public ResponseEntity<String> assignInputResponse(@RequestBody AssignDTO data) {
        try{
            assignService.assign(data);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
