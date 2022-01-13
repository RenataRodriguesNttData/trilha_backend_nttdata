package br.com.financys.repository;

import br.com.financys.entities.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface EntryRepository extends JpaRepository<Entry, Long > {


    List<Entry> findByentryContains(Long id, String name, String description, String type, String amount, String date, boolean paid, Long categoryId);


    Collection<Object> findByPaidContains(Long id);

}

