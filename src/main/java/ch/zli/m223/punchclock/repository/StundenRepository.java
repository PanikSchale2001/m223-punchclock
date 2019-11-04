package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Stunden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StundenRepository extends JpaRepository<Stunden, Long> {
}
