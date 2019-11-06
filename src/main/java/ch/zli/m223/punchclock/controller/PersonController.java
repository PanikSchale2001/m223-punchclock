package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import ch.zli.m223.punchclock.service.PersonenService;
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

    public PersonController(PersonenRepository personenRepository,
                            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personenRepository = personenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
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
}
