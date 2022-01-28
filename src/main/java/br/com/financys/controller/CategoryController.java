package br.com.financys.controller;


import br.com.financys.dto.CategoryDTO;
import br.com.financys.entities.Category;
import br.com.financys.mapper.CategoryMapper;
import br.com.financys.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    private CategoryDTO categoryDTO;

    private CategoryMapper categoryMapper;


    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO categoryDTO, Long Id) {
        Category categorySave = (Category) categoryService.save(categoryDTO.convertToEntity(Id));
        return ResponseEntity.ok().body(categoryDTO);
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Long> findByName(@PathVariable String name){
        Category idCategoryByName = categoryService.findByName(name);
        return ResponseEntity.ok().body(idCategoryByName.getId());
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return ResponseEntity.ok().body(categoryDTO);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long Id){
        categoryService.delete(Id);
        return ResponseEntity.noContent().build();
    }



}



