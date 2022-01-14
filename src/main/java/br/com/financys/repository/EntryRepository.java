package br.com.financys.repository;

import br.com.financys.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntryRepository extends JpaRepository<Entry, Long > {

    List<Entry> findAllByPaid(boolean pagos);

    Long findById(boolean id_não_encontrado);
}

