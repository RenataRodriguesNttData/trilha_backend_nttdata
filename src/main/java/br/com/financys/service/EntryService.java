package br.com.financys.service;


import br.com.financys.dto.ChartDTO;
import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import br.com.financys.mapper.EntryMapper;
import br.com.financys.repository.CategoryRepository;
import br.com.financys.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class EntryService {

    @Autowired
    private EntryRepository entryrepository;


    @Autowired
    private static CategoryRepository categoryRepository;


    private EntryMapper entryMapper;


    public List<Entry> findAll() {
        return entryrepository.findAll();

    }

    public Entry insert(EntryDTO entryDTO) {
        return entryMapper.save(entryDTO);
    }


    public Entry update(Long id, EntryDTO entryDTO) {
        Entry entry = entryrepository.findById(id).get();
        entry.setName(entryDTO.getName());
        entry.setDescription(entryDTO.getDescription());
        entry.setPaid(entryDTO.getPaid());
        entry.setDate(entryDTO.getDate());
        entry.setAmount(entryDTO.getAmount());
        entry.setCategory(entryDTO.getCategory());

        return entryrepository.save(entry);
    }

    public void delete(Long Id) {
        entryrepository.deleteById(Id);
    }

    public ResponseEntity.BodyBuilder ok() {
        return null;
    }

    public ResponseEntity<Entry> findAllById(Long id_validado) {
        return null;
    }


    public void validateCategoryById(boolean CategoryId){
        categoryRepository.findById(CategoryId);
    }

    public Entry findById(Long id) {
        return entryrepository.findById(id).get();
    }

    public static List<ChartDTO> ChartDto() {
        List<ChartDTO> listDto = new ArrayList<>();
        List<Category> listCategory =  categoryRepository.findAll();
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0 ; i <= listCategory.size()-1; i++){

            for (int j = 0 ; j <= listCategory.get(i).getEntry().size()-1; j++){
                total = total.add((BigDecimal) listCategory.get(i).getEntry().get(j));
            }
            listDto.add(new ChartDTO(listCategory.get(i).getName(),
                    listCategory.get(i).getType(),
                    total));
        }
        return listDto;
    }

    public Object save(EntryDTO entryDTO) {
        return null;
    }
}





