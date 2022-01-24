package br.com.financys.mapper;

import br.com.financys.dto.CategoryDTO;
import br.com.financys.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toCategoryDTO( Category category);

}