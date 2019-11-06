package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonenRepository extends JpaRepository<Person, Long> {
    Person findByUsername(String username);
}
