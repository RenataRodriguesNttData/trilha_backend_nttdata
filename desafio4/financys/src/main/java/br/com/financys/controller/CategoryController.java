package br.com.financys.controller;

import br.com.financys.crud.CategoryService;
import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
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
    private CategoryRepository categoryrepository;

    private final List<Category> lista = new ArrayList<>();

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


    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return CategoryService.createCategory(category);
    }

    @PostMapping("/addCategories")
    public List<Category> addCategory(@RequestBody List<Category> categories){
        return CategoryService.createCategory(categories);
    }

    @GetMapping("/Category/(id)")
    public Category getCtegoryById(@PathVariable int id) {
        return CategoryService.getCategoryById(id);
    }

    @GetMapping("/Categories")
    public List<Category> getAllCategories(){
        return CategoryService.getCategories();
    }

    @PutMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return CategoryService.updateCategory(category);
    }

    @DeleteMapping("/Category/{id}")
    public String deleteCategory(@PathVariable int id) {
        return CategoryService.deleteCategoryById(id);
    }









}

