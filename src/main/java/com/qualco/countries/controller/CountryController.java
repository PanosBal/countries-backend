package com.qualco.countries.controller;

import com.qualco.countries.dto.CountryDto;
import com.qualco.countries.dto.LanguageByCountryDto;
import com.qualco.countries.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/countries")
public class CountryController {
    private final CountryService countryService;

    @GetMapping
    public List<CountryDto> list() {
        return countryService.listCountries();
    }

    @GetMapping("/{id}/languages")
    public List<LanguageByCountryDto> getLanguages(
            @PathVariable("id") @Min(1) int countryId) {
        return countryService.listLanguages(countryId);
    }
}
