package br.com.financys.service;


import br.com.financys.dto.ChartDTO;
import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class EntryService {

    @Autowired
    private EntryRepository entryrepository;


    @Autowired
    private CategoryRepository categoryRepository;


    private final ModelMapper mapper = new ModelMapper();

    private final List<ChartDTO> chartDTOList = new ArrayList<>();

    public EntryService() {
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
    private EntryDTO mapToDTO(Entry entry) {
        return mapper.map(entry, EntryDTO.class);
    }

    private Entry mapToEntity(EntryDTO entryDTO) {
        return mapper.map(entryDTO, Entry.class);
    }

    public List<EntryDTO> getListDTO() {
        List<Entry> getEntries = entryrepository.findAll();
        entryrepository.getClass();
        return getEntries.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public Entry save(Object convertToEntity) {
        return null;
    }

    public Entry update(Object convertToEntity) {
        return null;
    }

    public Collection<Entry> findByPaid(boolean b) {
        return null;
    }
}





