package com.mrbot.backend.controller;

import com.mrbot.backend.DTO.InputDTO;
import com.mrbot.backend.entity.Input;
import com.mrbot.backend.entity.Response;
import com.mrbot.backend.service.InputService;
import com.mrbot.backend.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/bot/inputs")
public class InputController {
    @Autowired
    private InputService inputService;
    @Autowired
    private ResponseService responseService;

    @GetMapping
    public List<Input> getAllInputs(){
        return inputService.findInputs();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addInput(@RequestBody InputDTO inputDTO){
        try{
            inputService.save(inputDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Input created successfully");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
