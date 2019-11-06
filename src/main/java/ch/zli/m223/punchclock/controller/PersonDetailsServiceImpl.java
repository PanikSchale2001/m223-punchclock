package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService {
    private PersonenRepository personenRepository;

    public PersonDetailsServiceImpl(PersonenRepository personenRepository) {
        this.personenRepository = personenRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person applicationPerson;
        applicationPerson = personenRepository.findByUsername(username);
        if (applicationPerson == null) {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(applicationPerson.getUsername(), applicationPerson.getPassword(), emptyList());
    }
}