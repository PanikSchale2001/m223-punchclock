package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundenRepository extends JpaRepository<Kunde, Long> {
}
