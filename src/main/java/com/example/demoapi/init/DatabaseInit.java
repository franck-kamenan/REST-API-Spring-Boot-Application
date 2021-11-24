package com.example.demoapi.init;

import java.util.Arrays;
import java.util.List;

import com.example.demoapi.models.entities.Person;
import com.example.demoapi.repositories.PersonRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DatabaseInit implements InitializingBean{
    
    private final PersonRepository personRepository;

    public DatabaseInit(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info(">>> !! INITIALIZE DATABASE !! <<<");

        List<Person> persons = Arrays.asList(

            Person.builder()
                  .firstname("Muteba")
                  .lastname("Gizenga")
                  .build(),
            Person.builder()
                  .firstname("Teddy")
                  .lastname("Nelner")
                  .build(),
            Person.builder()
                  .firstname("Johnny")
                  .lastname("Waters")
                  .build(),
            Person.builder()
                  .firstname("Jerry")
                  .lastname("Tyson")
                  .build()
        );

        persons.forEach(this.personRepository::save);
    }
}
