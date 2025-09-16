package com.qualco.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private int countryId;
    private String name;
    private BigDecimal area;
    private String countryCode2;
}
