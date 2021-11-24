package com.example.demoapi.controllers;

import com.example.demoapi.models.entities.Person;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "demo")
public class DemoController {
    
    @GetMapping
    public ResponseEntity<String> getHello() {

        return ResponseEntity.ok("null");
    }
}
