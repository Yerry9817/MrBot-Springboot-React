package com.mrbot.backend.controller;

import com.mrbot.backend.DTO.ResponsesDTO;
import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.service.InputService;
import com.mrbot.backend.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bot/responses")
public class ResponseController {
    @Autowired
    private ResponseService responseService;

    @GetMapping
    public ResponseEntity<List<Response>> getResponses() {
        List<Response> responses = responseService.findResponses();
        return ResponseEntity.ok().body(new ArrayList<>(responses));
    }

    @PostMapping("/add")
    public ResponseEntity<String> addResponse(@RequestBody ResponsesDTO responseDTO) {
        try{
            responseService.save(responseDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Response created successfully");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
