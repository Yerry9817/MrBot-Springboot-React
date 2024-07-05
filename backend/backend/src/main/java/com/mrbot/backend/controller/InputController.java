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

        Input newInput= new Input();

        String inputContent = inputDTO.getContent();
        String ResponseContent = inputDTO.getResponse();

        Input inputAlreadyExist = inputService.findByContent(inputContent);

        if(inputAlreadyExist!=null){
            newInput = inputAlreadyExist;
        }
        newInput.setContent(inputContent);

        if(ResponseContent!=null){
            //find response by content
            Response response = responseService.findByContent(ResponseContent);
            if(response!=null){
                if(!newInput.getResponses().contains(response)){
                    newInput.getResponses().add(response);
                }
            }else{
                Response newResponse = new Response();
                newResponse.setContent(ResponseContent);
                Response savedResponse = responseService.save(newResponse);
                newInput.getResponses().add(savedResponse);
            }
        }

        inputService.save(newInput);
        return ResponseEntity.status(HttpStatus.OK).body("Input created successfully");
    }

    //moverlo a /chat
    @PostMapping("/chat")
    public ResponseEntity<String>chat(@RequestBody InputDTO inputDTO){
        Input input;
        Response response;
        String inputContent = inputDTO.getContent();
        if(!inputContent.isEmpty()){
            input = inputService.findByContent(inputContent);
            if(input != null){
                response = inputService.findResponsesByInputContent(inputContent);
                return ResponseEntity.status(HttpStatus.OK).body(response.getContent());

            }
        }
        return ResponseEntity.status(HttpStatus.OK).body("Lo lamento, no entendi tu pregunta");
    }



}
