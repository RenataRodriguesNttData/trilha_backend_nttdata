package br.com.financys.service;



import br.com.financys.dto.ChartDTO;
import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import br.com.financys.mapper.EntryMapper;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.hibernate.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EntryService {

    @Autowired
    private EntryRepository entryrepository;


    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private EntryMapper mapper;


    public List<Entry> findAll(){
        return entryrepository.findAll();

    }

    public boolean validateCategoryById(long categoryId){
        return categoryRepository.findById(categoryId).isPresent();
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

    public List<Entry> findAllByPaid(boolean paid) {
        return entryrepository.findAllByPaid(paid);
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
    public List<ChartDTO> grafico() {
        List<ChartDTO> retorno = new ArrayList<>();
        List<Category> categoryList =  categoryRepository.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0 ; i <= categoryList.size()-1; i++){

            for (int j = 0 ; j <= categoryList.get(i).getEntries().size()-1; j++){
                total = total.add(categoryList.get(i).getEntries().get(j).getamount());
            }
            retorno.add(new ChartDTO(categoryList.get(i).getName(),
                    categoryList.get(i).getType(),
                    total));
        }
        return retorno;
    }


    public Entry save(Object convertToEntity) {
        return null;
    }

    public Collection<Entry> findByPaid(boolean b) {
        return null;
    }

    public List<EntryDTO> getListDTO() {
        return null;
    }

    public Entry update(Object convertToEntity) {
        return null;
    }
}





