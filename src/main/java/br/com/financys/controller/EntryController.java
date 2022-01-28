package br.com.financys.controller;


import br.com.financys.dto.ChartDTO;
import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import br.com.financys.mapper.EntryMapper;
import br.com.financys.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;

    private EntryDTO entryDTO;

    private EntryMapper entryMapper;


    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid EntryDTO entryDTO) {
        entryService.validateCategoryById(entryDTO.getCategoryId().equals(entryDTO));
        return ResponseEntity.ok(entryService.save(entryDTO));
    }

    @GetMapping
    public ResponseEntity<List<Entry>> findAll(){
        List<Entry> list = entryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> findById(@PathVariable Long id){
        Entry  entry= entryService.findById(id);
        return ResponseEntity.ok().body(entry);
    }

    @GetMapping("/grafico")
    public ResponseEntity<List<ChartDTO>> grafico(){
        return ResponseEntity.ok(EntryService.grafico());
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody EntryDTO entryDTO) {
        return ResponseEntity.ok(entryService.update(id,entryDTO));
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



