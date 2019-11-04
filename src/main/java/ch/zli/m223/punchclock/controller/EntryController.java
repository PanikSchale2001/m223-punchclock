package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Stunden;
import ch.zli.m223.punchclock.service.EntryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Stunden> getAllEntries() {
        return entryService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stunden createEntry(@Valid @RequestBody Stunden stunden) {
        return entryService.createEntry(stunden);
    }
}
