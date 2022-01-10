package br.com.financys.controller;

import br.com.financys.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private  List<Category> lista = new ArrayList<>();

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
