package br.com.financys.dto;



import br.com.financys.entities.Entry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntryDTO<CategoryId> {

    @NotNull(message = " Este campo nao pode ser nulo")
    @Size(min = 3, max = 45)
    private String name;

    @NotNull(message = " Este campo nao pode ser nulo")
    @Size(min = 15, max = 150)
    private String description;

    @NotNull(message = " Este campo nao pode ser nulo")
    @Size(min = 3, max = 10)
    private String type;

    @NotNull(message = " Este campo nao pode ser nulo")
    @Min(value = 0, message = "O valor nao pode ser menor que 0")
    private String amount;

    @NotNull(message = " Este campo nao pode ser nulo")
    private String date;

    @NotNull(message = " Este campo nao pode ser nulo")
    private Boolean paid;

    private CategoryId categoryId;

    public static Object convertEntryDTO(Entry entry) {
        return null;
    }
}
