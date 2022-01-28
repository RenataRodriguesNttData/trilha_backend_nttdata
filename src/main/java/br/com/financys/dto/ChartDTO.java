package br.com.financys.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChartDTO {

    private String name;
    private BigDecimal total;

    public ChartDTO(String name, String type, BigDecimal total) {
    }
}