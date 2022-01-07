package br.com.financys.controller;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    private final List<Category> lista = new ArrayList<>();
    private CategoryRepository CategoryRepository;

    public void CategoryRepository(EntryRepository entryRepository) {
        this.CategoryRepository = categoryRepository;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<List<Category>> create(@RequestBody Category category) {
        Category category1 = new Category();
        category1.setId(category.getId());
        category1.setName(category.getName());
        category1.setDescription(category.getDescription());
        lista.add(category1);
        return ResponseEntity.status(HttpStatus.CREATED).body(lista);
    }


    @GetMapping("read")
    public ResponseEntity<List<Category>> read() {
        return ResponseEntity.ok().body(lista);
    }


}
