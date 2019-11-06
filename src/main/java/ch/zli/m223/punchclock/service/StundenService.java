package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Stunden;
import ch.zli.m223.punchclock.repository.StundenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StundenService {
    private StundenRepository stundenRepository;

    public StundenService(StundenRepository stundenRepository) {
        this.stundenRepository = stundenRepository;
    }

    public Stunden createEntry(Stunden stunden) {
        return stundenRepository.saveAndFlush(stunden);
    }

    public List<Stunden> findAll() {
        return stundenRepository.findAll();
    }

    /**
     * Löscht den Eintrag mit der mitgegebenen Id wird gelöscht.
     *
     * @param id
     */
    public void deleteEntry(long id) {
        stundenRepository.deleteById(id);
    }
}

