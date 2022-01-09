package br.com.financys.crud;

import br.com.financys.entities.Category;
import br.com.financys.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sun.beans.introspect.PropertyInfo.Name.description;
import static org.graalvm.compiler.nodeinfo.Verbosity.Id;
import static org.graalvm.compiler.nodeinfo.Verbosity.Name;

@Service
public class CategoryService {

    @Autowired
    private static CategoryRepository  CategoryRepository;


    public static Category createCategory(Category Category){
        return CategoryRepository.save(Category);
    }

    public static List<Category> createCategory(List<Category> Categories){
        return CategoryRepository.saveAll(Categories);
    }

    public static Category getCategoryById(int id){
        return CategoryRepository.findById(Id);
    }

    public static List<Category> getCategories() {
        return CategoryRepository.findALL();
    }

    public static Category updateCategory(Category category) {
        Optional<Category> optionalCategory=CategoryRepository.findById(Category.getId());
        if(optionalCategory.isPresent()){
            Category oldCategory=optionalCategory.get();
            oldCategory.setName(String.valueOf(Name));
            oldCategory.setDescription(String.valueOf(description));
            oldCategory.setDescription(String.valueOf(Long.valueOf(String.valueOf(Id))));
            CategoryRepository.save(oldCategory);
        }else{
            return new Category();
        }
        return category;
    }

    public static String deleteCategoryById(int id) {
        CategoryRepository.deleteById((long) id);
        return "Category got deleted";

    }

}

