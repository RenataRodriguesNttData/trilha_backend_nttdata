package br.com.arquiteturaDDD.domain.service;

import br.com.arquiteturaDDD.domain.entities.Category;
import br.com.arquiteturaDDD.infrastructure.mapper.CategoryMapper;
import br.com.arquiteturaDDD.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper mapper;


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
        Category entity = categoryRepository.getOne(Id);
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











