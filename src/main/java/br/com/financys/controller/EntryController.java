package br.com.financys.controller;


import br.com.financys.entities.Category;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import br.com.financys.entities.Entry;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

@RestController
@RequestMapping("/entries")
@SpringBootApplication

public class EntryController {

    private EntryRepository entryRepository;

    @Autowired
    public EntryController(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @GetMapping
    public List<Entry> readEntry(){
        return entryRepository.findAll();
    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return entryRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Entry createEntry(@RequestBody Entry entry){
        return entryRepository.save(entry);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody Entry entry) {
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
                    return ResponseEntity.ok().body(updated); })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void entrydelete(@PathVariable("id") Long id) {
        entryRepository.deleteById(id);
    }

    @RequestMapping(value="adicionarLancamento",method= RequestMethod.POST)
    public void category(@RequestParam("nome") String nome,
                         @RequestParam("id") String id,
                         @RequestParam("description") String description,
                         @RequestParam("amount") String amount,
                         @RequestParam("date") String date,
                         @RequestParam("paid") boolean paid,
                         @RequestParam("categoryId") Long categoryId,
                         @RequestParam("type") String type ) {
        if (Entry.isPresent()) {
        }
        Entry entry = new Entry();
        entry.setId(entry.getId());
        entry.setName(entry.getName());
        entry.setDescription(entry.getDescription());
    }


    @RequestMapping("/listaLancamentos")
    public String listaLancamentos(Model model)
    {
        if(Entry.isPresent())
            model.addAttribute(list());
        return "pessoa/listaPessoa";
    }

    @DeleteMapping("/deleteLancamento")
    public void lancamento(@RequestParam("lancamento") String Lancamento) {
        entryRepository.deleteById(Long.valueOf(Lancamento));
    }

}

