package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import ch.zli.m223.punchclock.service.PersonenService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PersonController {
    private PersonenService personenService;

    private PersonenRepository personenRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public PersonController(PersonenRepository personenRepository, BCryptPasswordEncoder bCryptPasswordEncoder, PersonenService personenService) {
        this.personenRepository = personenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.personenService = personenService;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        personenRepository.save(person);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> getAllPersons() {
        return personenService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  void deletePerson(@PathVariable("id")long id){
        personenService.deletePerson(id);
    }
/*
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updatePerson(@RequestBody Person newPerson){

        List<Person> personlist = personenService.findAll();

        personenService.updatePerson(newPerson, personlist);
    }*/
}
