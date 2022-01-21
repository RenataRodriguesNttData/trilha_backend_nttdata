package br.com.financys.dto;


import br.com.financys.entities.Entry;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("Entry DTO")
public class EntryDTO {

    @ApiModelProperty(value = "id")
    private  Long id;

    @ApiModelProperty(value = "category")
    private CategoryDTO categoryID;

    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "description")
    private String description;

    @ApiModelProperty(value = "type")
    private String type;

    @ApiModelProperty(value = "amount")
    private String amount;

    @ApiModelProperty(value = "date")
    private String date;

    @ApiModelProperty(value = "paid")
    private Boolean paid;

    public EntryDTO() {}

    public EntryDTO(Long id, CategoryDTO categoryID, String name, String description, String type, String amount, String date, Boolean paid) {
        this.id = id;
        this.categoryID = categoryID;
        this.name = name;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.paid = paid;
    }

    public EntryDTO(Long id, Long categoryId, String name, String description, String type, String amount, String date, boolean paid) {

    }

    public static EntryDTO convertEntryDTO(Entry entry) {
        return new EntryDTO(
                entry.getId(),
                entry.getCategoryId(),
                entry.getName(),
                entry.getDescription(),
                entry.getType(),
                entry.getAmount(),
                entry.getDate(),
                entry.getPaid()
        );

    }

    public CategoryDTO getCategoryID() {
        return categoryID;
    }

    public Object convertToEntity(Long categoryID) {
        return null;
    }
}
