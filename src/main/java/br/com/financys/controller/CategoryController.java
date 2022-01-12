package br.com.financys.controller;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;


@RestController
@RequestMapping("/categories")
public class CategoryController {


    private CategoryRepository categoryrepository;

    @Autowired
    public CategoryController(CategoryRepository categoryrepository) {
        this.categoryrepository = categoryrepository;
    }

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
    public Category createCategory(Category category){
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

    @RequestMapping(value="adicionarCategoria",method= RequestMethod.POST)
    public void category(@RequestParam("nome") String nome,
                         @RequestParam("id") String id,
                         @RequestParam("description") String description) {
        Category category = null;
        if (Category.isPresent()) {
        }category = new Category();
        category.setId(category.getId());
        category.setName(category.getName());
        category.setDescription(category.getDescription());
    }

    @RequestMapping("/listaCategoria")
    public String listaCategoria(Model model)
    {
        if(Category.isPresent())
        model.addAttribute(list());
        return "pessoa/listaPessoa";
    }

    @RequestMapping("editarCategoria")
    public String alterarPessoa(Long id, Model model)
    {
        if(Category.isPresent())
        model.addAttribute(getClass(id));
        return "editarCategoria";
    }

    private Object getClass(Long id) {
        return null;
    }

    @DeleteMapping("/deleteCategoria")
    public void categoria(@RequestParam("categoria") String Categoria) {
        categoryrepository.deleteById(Long.valueOf(Categoria));
    }

}

