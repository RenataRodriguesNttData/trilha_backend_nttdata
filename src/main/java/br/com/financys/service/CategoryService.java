package br.com.financys.service;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;




    public  List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByName( String name){
        return categoryRepository.findByName(name);

    }

    public  Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long Id, Category category){
        updateCategory(category);
        return categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        category.setName(category.getName());
        category.setId(category.getId());
        category.setDescription(category.getDescription());

    }

    public  void delete(Long Id){
        categoryRepository.deleteById(Id);
    }


    public Category save(Object convertToEntity) {
        return null;
    }

    public Optional<Category> findById(Long id) {
        return null;
    }

    public Category update(Object convertToEntity) {
        return null;
    }
}











