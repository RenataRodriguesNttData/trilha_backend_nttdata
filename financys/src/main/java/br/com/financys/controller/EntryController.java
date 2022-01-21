package br.com.financys.controller;


import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import br.com.financys.service.EntryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Api("Entries")
@RestController
@RequestMapping("/entries")
public class EntryController {

    @Autowired
    private EntryService entryService;


    @ApiOperation("/create")
    @PostMapping("/{categoryID}")
    public  ResponseEntity<EntryDTO> insert(@PathVariable Long categoryID, @Valid @RequestBody EntryDTO entryDTO) {
        Entry entrySave = entryService.save(entryDTO.convertToEntity(categoryID));
        return ResponseEntity.status(HttpStatus.CREATED).body(EntryDTO.convertEntryDTO(entrySave));
    }

    @ApiOperation("/Listar")
    @GetMapping(name = "/Listar")
    public List<EntryDTO> list () {
        return entryService.findAll().stream()
                .map(EntryDTO::convertEntryDTO)
                .collect(Collectors.toList());
    }

    @ApiOperation("/ListarId")
    @GetMapping(name = "/ListarId", path = {"/{id}"})
    public ResponseEntity<EntryDTO> find(@PathVariable Long id) {
        Optional<Entry> entry = Optional.ofNullable(entryService.findById(id));
        return entry.map(value -> ResponseEntity
                        .ok(EntryDTO.convertEntryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Update")
    @PutMapping(name = "Update", path = {"/{id}"})
    public ResponseEntity<EntryDTO> update(@PathVariable Long id, @Valid @RequestBody EntryDTO entryDTO) {
        Entry entryUpdate = entryService.update(entryDTO.convertToEntity(id));
        return ResponseEntity.ok(EntryDTO.convertEntryDTO(entryUpdate));
    }



    @ApiOperation("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "delete", path = {"/{id}"})
    public void delete(@PathVariable Long id) {entryService.delete(id);
    }

    @ApiOperation("/paid")
    @GetMapping(value = "/paid")
    public ResponseEntity<Collection<Entry>> findByPaid() {
        Collection<Entry> entries = entryService.findByPaid(true);
        return ResponseEntity.ok(entries);
    }

    @ApiOperation(value = "/RetornaGráfico")
    @GetMapping("/chart")
    public List<EntryDTO> getDTO() {
        return entryService.getListDTO();
    }


    private Exception newConstraintException(String id_not_exist) {
        return null;
    }


}



