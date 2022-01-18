package br.com.financys.controller;


import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<Category> insert(@RequestBody Category category){
        Category categoryReturn  = categoryService.insert(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Category.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryReturn);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long Id){
        Category idCategoryByName = categoryService.findById(Id);
        return ResponseEntity.ok().body(idCategoryByName);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.updateCategory(category);
        return ResponseEntity.ok().body(category);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id){
        categoryService.delete(Id);
        return ResponseEntity.noContent().build();
    }





}



