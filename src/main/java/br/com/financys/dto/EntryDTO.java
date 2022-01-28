package br.com.financys.dto;


import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntryDTO {


    private String name;
    private String description;
    private BigDecimal amount;
    private String date;
    private Boolean paid;

    private Category category;



    public Object getCategoryId() {
        return null;
    }
}