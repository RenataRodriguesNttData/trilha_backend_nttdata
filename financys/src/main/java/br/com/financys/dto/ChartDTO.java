package br.com.financys.dto;


import br.com.financys.entities.Category;
import br.com.financys.entities.Entry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {
    private String entryAmount;
    private String categoryTitle;
    private String entryTitle;
    private String entryType;
    private long amountSum;

    public ChartDTO(String entryAmount, String categoryTitle, String entryTitle, String entryType) {
        this.entryAmount = entryAmount;
        this.categoryTitle = categoryTitle;
        this.entryTitle = entryTitle;
        this.entryType = entryType;
    }

    public static ChartDTO convertDTO(Entry entry, Category category) {
        return new ChartDTO(
                entry.getAmount(),
                entry.getName(),
                category.getName(),
                entry.getType()
        );
    }

}
