package br.com.financys.service;


import br.com.financys.entities.Entry;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class EntryService {

    @Autowired
    private EntryRepository entryrepository;


    @Autowired
    private CategoryRepository categoryRepository;


    public List<Entry> findAll() {
        return entryrepository.findAll();

    }

    public Entry insert(Entry entry) {
        return entryrepository.save(entry);
    }

    public Entry update(Long Id, Entry entry) {
        Entry entity = entryrepository.getOne(Id);
        updateCreate(entity, entry);
        return entryrepository.save(entity);
    }

    private void updateCreate(Entry entity, Entry create) {
        entity.setName(create.getName());
        entity.setId(create.getId());
        entity.setDescription(create.getDescription());
        entity.setPaid(create.getPaid());
        entity.setDate(create.getDate());
        entity.setAmount(create.getAmount());
        entity.setType(create.getType());
        entity.setCategoryId(create.getCategoryId());
        entity.setCategory(create.getCategory());
    }

    public void delete(Long Id) {
        entryrepository.deleteById(Id);
    }

    public ResponseEntity.BodyBuilder ok() {
        return null;
    }

    public ResponseEntity<Entry> findAllById(String id_validado) {
        return null;
    }


    public boolean validateCategoryById(Entry entry) {
        if (categoryRepository.findById(entry.getCategory().getId()).isPresent()) {
            entryrepository.save(entry);
            return true;
        }
        System.out.println("Id não encontrado");
        return false;
    }

    public Entry findById(Long id) {
        return entryrepository.findById(id).get();
    }
}





