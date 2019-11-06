package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonenService {
    private PersonenRepository personenRepository;

    public PersonenService(PersonenRepository personenRepository) {
        this.personenRepository = personenRepository;
    }

    public List<Person> findAll() {
        return personenRepository.findAll();
    }
}
