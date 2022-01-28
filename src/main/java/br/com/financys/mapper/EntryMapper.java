package br.com.financys.mapper;


import br.com.financys.dto.EntryDTO;
import br.com.financys.entities.Entry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    Entry dtoEntry( EntryDTO entryDTO);

    EntryDTO entryDto(Entry entry);

    Entry save(EntryDTO entryDTO);
}

