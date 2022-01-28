package br.com.arquiteturaDDD.domain.repository;

import br.com.arquiteturaDDD.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CategoryRepository extends JpaRepository<Category, Long > {

    Category findByName(String name);
}
