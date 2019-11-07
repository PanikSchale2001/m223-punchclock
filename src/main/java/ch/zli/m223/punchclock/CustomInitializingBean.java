package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomInitializingBean implements InitializingBean {
    private PersonenRepository personenRepository;

    @Autowired
    public CustomInitializingBean(PersonenRepository personenRepository) {
        this.personenRepository = personenRepository;
    }


    @Override
    public void afterPropertiesSet() {
        personenRepository.save(new Person("Meier","Max", "Hauptstrasse 45", 8000,  "m.meier", "test"));
        personenRepository.save(new Person("Admin","Test", "Dorfstrasse 1", 8536,  "admin", "password"));
    }

}