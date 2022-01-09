package br.com.financys.repository;

import br.com.financys.entities.Entry;
import org.graalvm.compiler.nodeinfo.Verbosity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long > {

    static void deleteEntryById(long id) {
    }

    static List<Entry> findALL() {
        return null;
    }

    static Entry Save(Entry oldEntry) {
        return oldEntry;
    }

    static List<Entry> SaveAll(List<Entry> entries) {
        return entries;
    }

    static Entry findById(Verbosity id) {
        return null;
    }
}

