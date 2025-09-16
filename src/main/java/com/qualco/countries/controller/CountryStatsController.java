package com.qualco.countries.controller;

import com.qualco.countries.dto.CountryStatsMaxGdpRatioDto;
import com.qualco.countries.dto.CountryStatsViewDto;
import com.qualco.countries.dto.PageDto;
import com.qualco.countries.service.CountryStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class CountryStatsController {

    private final CountryStatsService countryStatsService;

    @GetMapping("/max-gdp-per-pop")
    public List<CountryStatsMaxGdpRatioDto> getMaxGdpPerPopulation() {
        return countryStatsService.getMaxGdpPerPopulation();
    }

    @GetMapping("/country-stats")
    public PageDto<CountryStatsViewDto> getCountryStats(
            @RequestParam(required = false) Integer regionId,
            @RequestParam(required = false) Integer yearFrom,
            @RequestParam(required = false) Integer yearTo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        return countryStatsService.searchStats(regionId, yearFrom, yearTo, page, size);
    }
}