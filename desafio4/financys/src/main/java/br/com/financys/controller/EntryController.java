package br.com.financys.controller;


import br.com.financys.crud.EntryService;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.financys.entities.Entry;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entries")
@SpringBootApplication

public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    private final List<Entry> lista = new ArrayList<>();

    @PostMapping("/create")
    public ResponseEntity<List<Entry>> create(@RequestBody Entry entry) {
        Entry entry1 = new Entry();
        entry1.setId(entry.getId());
        entry1.setName(entry.getName());
        entry1.setDescription(entry.getDescription());
        entry1.setType(entry.getType());
        entry1.setAmount(entry.getAmount());
        entry1.setDate(entry.getDate());
        entry1.setPaid(entry.isPaid());
        entry1.setCategoryId(entry.getCategoryId());
        lista.add(entry1);
        return ResponseEntity.status(HttpStatus.CREATED).body(lista);
    }

    @GetMapping("read")
    public ResponseEntity<List<Entry>> read() {
        return ResponseEntity.ok().body(lista);
    }


    private EntryService entryService;

    @PostMapping("/addEntry")
    public Entry addEntry(@RequestBody Entry entry){
        return EntryService.createEntry(entry);
    }

    @PostMapping("/addEntries")
    public List<Entry> addEntry(@RequestBody List<Entry> entries){
        return EntryService.createEntry(entries);
    }

    @GetMapping("/Entry/(id)")
    public Entry getEntryById(@PathVariable int id) {
        return EntryService.getEntryById(id);
    }

    @GetMapping("/Entries")
    public List<Entry> getAllEntries(){
        return EntryService.getEntries();
    }

    @PutMapping("/updateEntry")
    public Entry updateEntry(@RequestBody Entry entry) {
        return EntryService.updateEntry(entry);
    }

    @DeleteMapping("/Entry/{id}")
    public String deleteEntry(@PathVariable int id) {
        return EntryService.deleteEntryById(id);
    }

}

