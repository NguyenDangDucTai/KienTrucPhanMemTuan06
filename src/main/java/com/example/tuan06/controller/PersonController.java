package com.example.tuan06.controller;


import com.example.tuan06.model.Person;
import com.example.tuan06.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;
    
    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPerson(){
        List<Person> lst = personRepository.findAll();
        return ResponseEntity.ok(lst);
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id){
        return personRepository.findById(id);
    }


}
