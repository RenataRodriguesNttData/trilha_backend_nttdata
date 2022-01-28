package br.com.arquiteturaDDD.domain.repository;

import br.com.arquiteturaDDD.domain.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface EntryRepository extends JpaRepository<Entry, Long > {

}

