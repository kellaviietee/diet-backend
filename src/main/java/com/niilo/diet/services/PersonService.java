package com.niilo.diet.services;

import com.niilo.diet.entities.Person;
import com.niilo.diet.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    Person createTestPerson() {
        Person person = new Person();
        person.setName("Lauri");
        return person;
    }
}
