package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void deletePerson(long id){
        personenRepository.deleteById(id);
    }
/*
    public void updatePerson(Person newPerson, List<Person> personlist) {
        long id = newPerson.getId();
        String firstname = newPerson.getFirstname();
        String lastname = newPerson.getLastname();
        String street = newPerson.getStreet();
        int zip = newPerson.getZip();
        Date birthdate = newPerson.getBirthdate();
        Sting username = newPerson.getUsername();


    }*/
}
