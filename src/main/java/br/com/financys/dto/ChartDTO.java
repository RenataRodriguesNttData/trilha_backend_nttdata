package br.com.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChartDTO {

    private String name;
    private String type;
    private String total;


    public ChartDTO(String name, String type, BigDecimal total) {
    }
}