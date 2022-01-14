package br.com.financys.controller;

import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import br.com.financys.entities.Entry;


import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/entries")
@SpringBootApplication

public class EntryController {

    private EntryRepository entryRepository;

    @Autowired
    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Entry create(@RequestBody Entry entry){
        return entryRepository.save(entry);
    }

    @GetMapping("/readList")
    public List<Entry> findAll() {
        var entryList = entryRepository.findAll();
        return entryList
                .stream()
                .map(Entry::converter)
                .collect(Collectors.toList());
    }
    @GetMapping("/filter")
    public List<Entry> findPersonByPaid(@RequestParam("paid") String paid) {
        return this.entryRepository.findByPaidContains(Long.valueOf(paid))
                .stream()
                .map(Entry::converter)
                .collect(Collectors.toList());
    }

            @PutMapping(value = "/update/{id}")
            public ResponseEntity update (@PathVariable("id") Long id, @RequestBody Entry entry){
                return entryRepository.findById(id)
                        .map(record -> {
                            record.setName(entry.getName());
                            record.setId(entry.getId());
                            record.setDescription(entry.getDescription());
                            record.setType(entry.getType());
                            record.setAmount(entry.getAmount());
                            record.setDate(entry.getDate());
                            record.setPaid(entry.getPaid());
                            record.setCategoryId(entry.getCategoryId());
                            Entry updated = entryRepository.save(record);
                            return ResponseEntity.ok().body(updated);
                        })
                        .orElse(ResponseEntity.notFound().build());
            }

            @DeleteMapping("/delete/{id}")
            public void entrydelete (@PathVariable("id") Long id){
                entryRepository.deleteById(id);
            }

        }



