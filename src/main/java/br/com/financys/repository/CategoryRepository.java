package br.com.financys.repository;

import br.com.financys.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long > {

    Category findByName(String name);
}
