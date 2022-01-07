package br.com.financys.controller;

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


}

