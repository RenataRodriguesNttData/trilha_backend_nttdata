package br.com.arquiteturaDDD.infrastructure.mapper;



import br.com.arquiteturaDDD.aplication.dto.EntryDTO;
import br.com.arquiteturaDDD.domain.entities.Entry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntryMapper {

    EntryDTO toEntryDTO(Entry entry);

}
