package ch.zli.m223.punchclock;

import ch.zli.m223.punchclock.domain.Person;
import ch.zli.m223.punchclock.repository.PersonenRepository;
import ch.zli.m223.punchclock.service.PersonenService;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class PunchclockApplication {

	public static void main(String[] args) {
		SpringApplication.run(PunchclockApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
