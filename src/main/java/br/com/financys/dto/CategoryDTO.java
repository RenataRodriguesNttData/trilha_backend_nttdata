package br.com.financys.dto;

import br.com.financys.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO {


    @NotNull(message = " Este campo nao pode ser nulo" )
    @Size(min = 3, max = 15)
    private String name;

    @NotNull(message = " Este campo nao pode ser nulo")
    @Size(min = 15, max = 50)
    private String description;



    public static Object convertToCategoryDTO(Category categorySave) {
        return null;
    }


    public Object convertToEntity(Long id) {
        return null;
    }
}
