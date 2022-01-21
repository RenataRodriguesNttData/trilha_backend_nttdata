package br.com.financys.controller;

import br.com.financys.dto.CategoryDTO;
import br.com.financys.entities.Category;
import br.com.financys.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Api("/Categories")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @ApiOperation("/createDTO")
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> insert(@Valid @RequestBody CategoryDTO categoryDTO, Long Id) {
        Category categorySave = (Category) categoryService.save(categoryDTO.convertToEntity(Id));
        return (ResponseEntity<CategoryDTO>) ResponseEntity.status(HttpStatus.CREATED).body(CategoryDTO.convertToCategoryDTO(categorySave));
    }

    @ApiOperation("/ListarDTO")
    @GetMapping("/Listar")
    public List<Object> list () {
        return categoryService.findAll().stream().map(CategoryDTO::convertToCategoryDTO)
                .collect(Collectors.toList());
    }

    @ApiOperation("/Listar{Id}")
    @GetMapping(name = "/Listar", path = {"/{id}"})
    public ResponseEntity<Object> find(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(value -> ResponseEntity
                        .ok(CategoryDTO.convertToCategoryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @ApiOperation("/Update")
    @PutMapping(name = "/UpdateId", path = {"/{id}"})
    public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDto) {
        Category category = categoryService.update(categoryDto.convertToEntity(id));
        return (ResponseEntity<CategoryDTO>) ResponseEntity.ok(CategoryDTO.convertToCategoryDTO(category));
    }

    @ApiOperation("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(name = "delete", path = {"/{id}"})
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}



