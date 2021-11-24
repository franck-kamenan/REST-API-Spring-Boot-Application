package com.example.demoapi.mappers;

import com.example.demoapi.models.dtos.PersonDTO;
import com.example.demoapi.models.entities.Person;
import com.example.demoapi.models.forms.PersonForm;

import org.springframework.stereotype.Service;

@Service
public class PersonMapper implements BaseMapper<PersonDTO, PersonForm, Person>{
    
    public Person formToEntity(PersonForm form){

        Person p = new Person();
        p.setFirstname(form.getFirstname());
        p.setLastname(form.getLastname());

        return p;
    }

    public PersonDTO toDto(Person person) {

        if (person != null && person.getId() > 0) {

            return PersonDTO.builder()
                            .id(person.getId())
                            .lastname(person.getLastname())
                            .firstname(person.getFirstname())
                            .build();
        }

        return null;
    }

    public Person dtoToEntity(PersonDTO dto) {

        Person p = new Person();
        if (dto != null && dto.getId() > 0) {

            p.setId(dto.getId());
            p.setFirstname(dto.getFirstname());
            p.setLastname(dto.getLastname());
        }

        return p;
    }
}
