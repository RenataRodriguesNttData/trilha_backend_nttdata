package br.com.financys.repository;

import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long > {
    List<Category> findALL();

    static <id> Category findById(Long id){
        return null;
    }

    Entry findById(Class<? extends Long> aClass);

    List<Category> findIdCategoryByName(String name);
}
