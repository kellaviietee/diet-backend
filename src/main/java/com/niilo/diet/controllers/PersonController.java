package com.niilo.diet.controllers;

import com.niilo.diet.entities.Person;
import com.niilo.diet.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
@CrossOrigin
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping(path = "/all")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    @PostMapping(path = "/add")
    public Person savePerson(@RequestBody Person person) {
        return personService.savePerson(person);
    }
}
