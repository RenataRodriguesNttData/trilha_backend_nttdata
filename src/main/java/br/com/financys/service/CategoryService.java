package br.com.financys.service;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService<categoryRepository> {

    @Autowired
    private  CategoryRepository categoryRepository;



    public  List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category find(PageRequest PageRequest, String name){
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

    public void updateCategory(Category entity) {
        entity.setName(Category.getName());
        entity.setId(Category.getId());
        entity.setDescription(Category.getDescription());

    }

    public  void delete(Long Id){
        categoryRepository.deleteById(Id);
    }


    public  Category findById(Long id) {
        return null;
    }



}











