package br.com.financys.controller;

import br.com.financys.entities.Category;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import br.com.financys.entities.Entry;


import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/entries")
public class EntryController {

    private EntryRepository entryRepository;

    @Autowired
    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @PostMapping("/create")
    public Long createEntry(@RequestBody Entry entry) {
        if (id != null )
                return entryRepository.findById(id.equals("Id não encontrado"));
        return entryRepository.save(entry).getId();
    }

    @GetMapping("/read/{id}")
    public Entry findById(@PathVariable Long id) {
        return entryRepository.findById(id).get();
    }

    @GetMapping
    public List<Entry> findAll(@RequestParam(required = false) String paid) {
        if (paid != null)
            return entryRepository.findAllByPaid(paid.equalsIgnoreCase("pagos"));
        return entryRepository.findAll();
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Entry entry) {
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
    public void entrydelete(@PathVariable("id") Long id) {
        entryRepository.deleteById(id);
    }

}



