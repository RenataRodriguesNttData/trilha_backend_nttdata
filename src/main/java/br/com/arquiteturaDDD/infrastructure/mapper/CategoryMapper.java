package br.com.arquiteturaDDD.infrastructure.mapper;


import br.com.arquiteturaDDD.aplication.dto.CategoryDTO;
import br.com.arquiteturaDDD.domain.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDTO( Category category);

}