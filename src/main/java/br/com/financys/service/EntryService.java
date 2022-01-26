package br.com.financys.service;


import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.hibernate.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.stream.Collectors.toList;


@Service
public class EntryService {

    @Autowired
    private EntryRepository entryrepository;


    @Autowired
    private CategoryRepository categoryRepository;



    public void validateCategoryById(Boolean categoryId) {
        categoryRepository.findById(categoryId);
    }

    public List<Entry> findAll(){
        return entryrepository.findAll();

    }

    public Entry findById(final Long Id) {
        try {
            return entryrepository.findById(Id).orElse(null);
        } catch (NoSuchElementException e) {
            throw new ObjectNotFoundException(EntryService.class,
                    "Não encontrado " + Id + " tipo:" +
                            Entry.class.getName());
        }
    }

     public Entry insert(Entry entry) {
         try {
             return entryrepository.save(entry);
         } catch (DataIntegrityViolationException e) {
             throw new DataIntegrityViolationException("Campos obrigatórios vazios");
         }
     }


    public Entry update(Long Id, Entry entry){
        return entryrepository.save(entry);
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

    public void delete(Long Id){
        entryrepository.deleteById(Id);
}

    public List<Object> getListDTO() {
        List<Entry> getEntry = entryrepository.findAll();
        return getEntry.stream().map(Entry::getListDTO).collect(toList());
    }

    public Collection<Entry> findByPaid(boolean b) {
        return null;
    }

    public Object save(@Valid EntryDTO id) {
        return null;
    }
}







