package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Stunden;
import ch.zli.m223.punchclock.service.StundenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private StundenService stundenService;

    public EntryController(StundenService stundenService) {
        this.stundenService = stundenService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Stunden> getAllEntries() {
        return stundenService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stunden createEntry(@Valid @RequestBody Stunden stunden) {
        return stundenService.createEntry(stunden);
    }
}
