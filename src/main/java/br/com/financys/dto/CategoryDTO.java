package br.com.financys.dto;


import br.com.financys.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDTO {


    private String name;
    private String description;


    public Category convertToEntity(Long id) {
        return null;
    }
}