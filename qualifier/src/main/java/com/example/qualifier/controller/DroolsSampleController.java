package com.example.qualifier.controller;

import com.example.qualifier.model.Participant;
import com.example.qualifier.model.Rate;
import com.example.qualifier.service.DroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/bankservice")
public class DroolsSampleController {

    @Autowired
    private DroolsService bankService;

    @PostMapping("/getrate")
    public ResponseEntity<Rate> getRate(@RequestBody Participant request){
        Rate rate = bankService.getRate(request);
        return new ResponseEntity<>(rate, HttpStatus.OK);
    }

}