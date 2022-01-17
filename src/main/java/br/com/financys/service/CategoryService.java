package br.com.financys.service;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{

    @Autowired
    private static CategoryRepository categoryRepository;

    public static List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category idCategoryByName(long Id) {
        Optional<Category> id = Optional.ofNullable(CategoryRepository.findById(Id));
        return id.get();
    }

    public static Category insert(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Long Id, Category category){
        Category entity = categoryRepository.getOne(Id);
        updateCategory(category);
        return categoryRepository.save(entity);
    }

    public static void updateCategory(Category entity) {
        entity.setName(Category.getName());
        entity.setId(Category.getId());
        entity.setDescription(Category.getDescription());

    }

    public static void delete(Long Id){
        categoryRepository.deleteById(Id);
    }


    public static Category findById(Long id) {
        return null;
    }

}











