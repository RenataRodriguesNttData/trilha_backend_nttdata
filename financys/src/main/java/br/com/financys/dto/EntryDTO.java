package br.com.financys.dto;

import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDTO {


    private String name;
    private String description;
    private String amount;
    private String date;
    private Boolean paid;

    private Category categoryId;

    public static Object convertEntryDTO(Entry entrySave) {
        return null;
    }

    public Object convertToEntity(Long categoryID) {
        return null;
    }
}
