package br.com.financys.mapper;

import br.com.financys.dto.CategoryDTO;
import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    CategoryDTO toCategoryDTO( Category category);

    EntryDTO map(Entry entry, Class<EntryDTO> entryDTOClass);
}