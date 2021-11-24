package com.example.demoapi.controllers;

import java.util.List;

import com.example.demoapi.models.dtos.PersonDTO;
import com.example.demoapi.models.entities.Person;
import com.example.demoapi.services.impl.PersonServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/person")
public class PersonController {
    
    private final PersonServiceImpl personServiceImpl;

    public PersonController(PersonServiceImpl personServiceImpl) {

        this.personServiceImpl = personServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getList() {

        return ResponseEntity.ok(this.personServiceImpl.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDTO> getOneById(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(this.personServiceImpl.getOneById(id));
    }
}