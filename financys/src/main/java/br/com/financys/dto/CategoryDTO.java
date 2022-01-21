package br.com.financys.dto;

import br.com.financys.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private String name;

    private String description;

    public static Object convertToCategoryDTO(Category categorySave) {
        return null;
    }

    public CategoryDTO convertToEntity(Long id) {
        return null;
    }
}
