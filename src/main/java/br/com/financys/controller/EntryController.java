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

    @GetMapping("/read")
    public List<Entry> findpersonByPaid(@RequestParam("paid") Long id) {
        return this.entryRepository.findByPaidContains(id)
                .stream()
                .map(Entry::converter)
                .collect(Collectors.toList());

    }


    @GetMapping("/List")
    public List<Entry> findPersonByCustom(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "amount", required = false) String amount,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "paid", required = false) boolean paid,
            @RequestParam(value = "categoryId", required = false) Long categoryId

    ) {
        return this.entryRepository.find(id, name, description, type, amount, date, paid, categoryId )
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



