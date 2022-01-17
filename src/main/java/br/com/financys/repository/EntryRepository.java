package br.com.financys.repository;

import br.com.financys.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EntryRepository extends JpaRepository<Entry, Long > {

    static Entry Save(Entry entry) {
        return entry;
    }

    static List<Entry> SaveAll(List<Entry> entries) {
        return entries;
    }

    static List<Entry> findALL() {
        return null;
    }

    static void deleteEntryById(long id) {
    }

    default Optional<Entry> findById(Long id) {
        return null;
    }

    List<Entry> findAllByPaid(boolean pagos);

    Long findById(boolean id_não_encontrado);

    Entry getOne(Entry id);

    Long findById();
}

