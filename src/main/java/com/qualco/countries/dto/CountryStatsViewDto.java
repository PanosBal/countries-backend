package com.qualco.countries.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryStatsViewDto {
    private String continentName;
    private int regionId;
    private String regionName;
    private String countryName;
    private Integer year;
    private Long population;
    private Long gdp;
}
