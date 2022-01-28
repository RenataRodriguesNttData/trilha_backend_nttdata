package br.com.arquiteturaDDD.presentation.controller;


import br.com.arquiteturaDDD.aplication.dto.CategoryDTO;
import br.com.arquiteturaDDD.domain.entities.Category;
import br.com.arquiteturaDDD.domain.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/create")
    public ResponseEntity<Category> insert(@RequestBody Category category){
        Category categoryReturn  = categoryService.insert(category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryReturn);
    }


    @GetMapping("/Listar")
    public List<Object> list () {
        return categoryService.findAll().stream().map(CategoryDTO::convertToCategoryDTO)
                .collect(Collectors.toList());
    }


    @GetMapping(name = "/Listar", path = {"/{id}"})
    public ResponseEntity<Object> find(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(value -> ResponseEntity
                        .ok(CategoryDTO.convertToCategoryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category category) {
        categoryService.updateCategory(category);
        return ResponseEntity.ok().body(category);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "delete", path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }


}



