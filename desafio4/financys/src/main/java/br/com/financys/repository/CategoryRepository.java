package br.com.financys.repository;

import br.com.financys.entities.Category;
import org.graalvm.compiler.nodeinfo.Verbosity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long > {


    Category findById(Verbosity id);

    List<Category> findALL();
}