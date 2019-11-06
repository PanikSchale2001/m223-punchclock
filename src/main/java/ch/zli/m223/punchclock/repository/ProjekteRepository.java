package ch.zli.m223.punchclock.repository;

import ch.zli.m223.punchclock.domain.Projekt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjekteRepository extends JpaRepository<Projekt, Long> {
}
