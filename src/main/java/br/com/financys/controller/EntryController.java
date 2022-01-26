package br.com.financys.controller;


import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import br.com.financys.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid EntryDTO entryDTO) {
        entryService.validateCategoryById(entryDTO.getCategoryId().equals(entryDTO));
        return ResponseEntity.ok(entryService.save(entryDTO));
    }


    @GetMapping(name = "/Listar")
    public List<Object> list () {
        return entryService.findAll().stream()
                .map(EntryDTO::convertEntryDTO)
                .collect(Collectors.toList());
    }


    @GetMapping(name = "/ListarId", path = {"/{id}"})
    public ResponseEntity<Object> find(@PathVariable Long id) {
        Optional<Entry> entry = Optional.ofNullable(entryService.findById(id));
        return entry.map(value -> ResponseEntity
                        .ok(EntryDTO.convertEntryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Entry> update(@PathVariable Long id, @RequestBody Entry update) {
        return ResponseEntity.ok(entryService.update(id,update));
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "delete", path = {"/{id}"})
    public void delete(@PathVariable Long id) {entryService.delete(id);
    }


    @GetMapping(value = "/paid")
    public ResponseEntity<Collection<Entry>> findByPaid() {
        Collection<Entry> entries = entryService.findByPaid(true);
        return ResponseEntity.ok(entries);
    }


    @GetMapping("/chart")
    public List<Object> getDTO() {
        return entryService.getListDTO();
    }


    private Exception newConstraintException(String id_not_exist) {
        return null;
    }


}



