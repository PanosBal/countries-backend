package com.qualco.countries.service;

import com.qualco.countries.dto.CountryDto;
import com.qualco.countries.dto.LanguageByCountryDto;
import com.qualco.countries.mapper.CountryMapper;
import com.qualco.countries.validator.CountryValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor


public class CountryService {
    private final CountryMapper countryMapper;
    private final CountryValidator countryValidator;

    public List<CountryDto> listCountries() {
        return countryMapper.listCountries();
    }

    public List<LanguageByCountryDto> listLanguages(int countryId) {
        countryValidator.validateExists(countryId);
        return countryMapper.languagesByCountryId(countryId);
    }
}
