package br.com.arquiteturaDDD.presentation.controller;


import br.com.arquiteturaDDD.aplication.dto.EntryDTO;
import br.com.arquiteturaDDD.domain.entities.Entry;
import br.com.arquiteturaDDD.domain.service.EntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @PostMapping("/{categoryID}")
    public ResponseEntity<Object> create(@RequestBody EntryDTO id) {
        if (entryService.validateCategoryById((Long) id.getCategoryId()))
            return ResponseEntity.ok(entryService.save(id));
        return ResponseEntity.badRequest().body("Categoria inexistente");
    }


    @GetMapping(name = "/Listar")
    public List<Object> list() {
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
        return ResponseEntity.ok(entryService.update(id, update));
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "delete", path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        entryService.delete(id);
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


    @GetMapping("/Calcula {x},{y}")
    public Integer calculaMedia(@PathVariable Integer x, @PathVariable Integer y) throws Exception {
        try {
            return (x / y);
        } catch (Exception ex) {
            throw new Exception("número incorreto");
        }

    }

}



