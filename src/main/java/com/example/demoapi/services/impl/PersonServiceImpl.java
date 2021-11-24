package com.example.demoapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demoapi.mappers.PersonMapper;
import com.example.demoapi.models.dtos.PersonDTO;
import com.example.demoapi.models.entities.Person;
import com.example.demoapi.models.forms.PersonForm;
import com.example.demoapi.repositories.PersonRepository;
import com.example.demoapi.services.BaseService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonServiceImpl implements BaseService<PersonDTO, PersonForm, Long>{

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {

        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public List<PersonDTO> getAll() {

        return this.personRepository
                   .findAll()
                   .stream()
                   .map(this.personMapper::toDto)
                   .collect(Collectors.toList());
    }

    public PersonDTO getOneById(Long id) {

        return this.personMapper
                   .toDto(this.personRepository
                             .findById(id)
                             .orElse(null));        
    }

    public void insert(PersonForm form) {

        Person p =this.personMapper
                      .formToEntity(form);
        
        this.personRepository
            .save(p);
    }

    @Override
    public void delete(Long id) {

        Person p = this.personRepository
                       .findById(id)
                       .orElse(null);

        this.personRepository
            .delete(p);
    }

    @Override
    public PersonDTO update(PersonForm form, Long id) {

        Person p = this.personRepository
                       .findById(id)
                       .orElse(null);

        p.setFirstname(form.getFirstname());
        p.setLastname(form.getLastname());
        this.personRepository
            .save(p);

        return this.personMapper
                   .toDto(p);
    }
}
