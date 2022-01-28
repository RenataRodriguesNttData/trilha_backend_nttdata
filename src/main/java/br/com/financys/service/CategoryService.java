package br.com.financys.service;

import br.com.financys.dto.CategoryDTO;
import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    private CategoryDTO categoryDTO;


    public  List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByName( String name){
        return categoryRepository.findByName(name);

    }

    public  Category insert(Category categoryDTO) {;
        return categoryRepository.save(categoryDTO);
    }

    public Category update(Long Id, Category category){
        Category entity = categoryRepository.getById(category.getId());
        updateCategory(category);
        return categoryRepository.save(entity);
    }

    public void updateCategory(Category category) {
        category.setName(category.getName());
        category.setId(category.getId());
        category.setDescription(category.getDescription());

    }

    public  void delete(Long Id){
        categoryRepository.deleteById(Id);
    }


    public  Category findById(Long id) {
        return null;
    }


    public Object save(Category convertToEntity) {
        return null;
    }
}











