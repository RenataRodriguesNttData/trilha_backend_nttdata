package br.com.financys.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {

    private String name;
    private String type;
    private String total;



}
