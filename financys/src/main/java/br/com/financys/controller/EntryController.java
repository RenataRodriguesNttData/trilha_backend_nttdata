package br.com.financys.controller;


import br.com.financys.entities.Entry;
import br.com.financys.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @PostMapping("/create/{validateCategoryById}")
    public ResponseEntity<Entry> create(@RequestBody Entry entry) throws Exception {
        if (entryService.validateCategoryById(entry.getCategoryId())){
            URI uri  = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(entry.getId()).toUri();
            return ResponseEntity.created(uri).body(entry);
        } else {
            throw newConstraintException("Id not exist");
        }
    }

    @GetMapping
    public ResponseEntity<List<Entry>> findAll(){
        List<Entry> list = entryService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Entry> update(@PathVariable("id") Long id, @RequestBody Entry entry) {
        Entry update = entryService.update(id, entry);
        return ResponseEntity.ok().body(update);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id){
        entryService.delete(Id);
        return ResponseEntity.noContent().build();
    }

    private Exception newConstraintException(String id_not_exist) {
        return null;
    }


}



