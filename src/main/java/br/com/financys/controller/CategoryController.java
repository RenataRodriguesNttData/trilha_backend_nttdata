package br.com.financys.controller;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryrepository;

    @GetMapping
    public List<Category> readCategory(){
        return categoryrepository.findAll();
    }
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable Long id){
        return categoryrepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Category createCategory(@RequestBody Category category){
        return categoryrepository.save(category);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id,@RequestBody Category category) {
        return categoryrepository.findById(id)
                .map(record -> {
                    record.setName(category.getName());
                    record.setId(category.getId());
                    record.setDescription(category.getDescription());
                    Category updated = categoryrepository.save(record);
                    return ResponseEntity.ok().body(updated); })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public void categorydelete(@PathVariable("id") Long id) {
        categoryrepository.deleteById(id);
    }





}

