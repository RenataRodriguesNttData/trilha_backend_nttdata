package br.com.financys.service;


import br.com.financys.entities.Entry;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Service
    public class EntryService {

        @Autowired
        private EntryRepository entryrepository;


        @Autowired
        private CategoryRepository categoryRepository;


        public List<Entry> findAll(){
            return entryrepository.findAll();

        }

        public Entry validateCategoryById(@RequestParam(required = false) Long Id, Entry entry) {
            if (entryrepository.findById(entry.getCategoryId()).isPresent())
                return entryrepository.save(entry);
            System.out.println("Id não encontrado");
            return  null;
        }

         public Entry insert(Entry entry) {
            return entryrepository.save(entry);
        }

        public Entry update(Long Id, Entry entry){
            Entry entity = entryrepository.getOne(Id);
            updateCreate(entity,entry);
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

        public void delete(Long Id){
            entryrepository.deleteById(Id);
    }


         public Entry save(EntryService entryService) {
        return null;
    }

    public Entry findById(Long id) {
        return null;
    }
}





