package br.com.financys.service;

import br.com.financys.dto.CategoryDTO;
import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper){
        this.categoryRepository = categoryRepository;
        this.mapper = modelMapper;
    }


    public  List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByName(String name){
        return categoryRepository.findByName(name);

    }

    public  Category insert(Category category) {
        return categoryRepository.save(category);
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

    public CategoryDTO mapToDTO(Category category){
        return mapper.map(category,CategoryDTO.class);
    }

    public Category save(Object convertToEntity) {
        return null;
    }

    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    public Category update(Object convertToEntity) {
        return null;
    }
}











