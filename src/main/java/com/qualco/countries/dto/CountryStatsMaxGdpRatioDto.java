package com.qualco.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryStatsMaxGdpRatioDto {
    private String name;
    private String countryCode3;
    private Integer year;
    private Long population;
    private BigDecimal gdp;
}
