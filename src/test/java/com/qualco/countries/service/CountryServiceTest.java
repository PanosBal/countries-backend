package com.qualco.countries.service;

import com.qualco.countries.dto.CountryDto;
import com.qualco.countries.dto.LanguageByCountryDto;
import com.qualco.countries.mapper.CountryMapper;
import com.qualco.countries.validator.CountryValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static com.qualco.countries.mock.MockData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CountryServiceTest {

    private CountryMapper countryMapper;
    private CountryService countryService;
    private CountryValidator countryValidator;

    @BeforeEach
    void setUp() {
        countryMapper = Mockito.mock(CountryMapper.class);
        countryValidator = Mockito.mock(CountryValidator.class);
        countryService = new CountryService(countryMapper, countryValidator);
    }

    @Test
    void listCountriesTest() {
        List<CountryDto> mockCountry = getCountries();
        when(countryMapper.listCountries()).thenReturn(mockCountry);

        List<CountryDto> result = countryService.listCountries();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getCountryId()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("Afghanistan");
        assertThat(result.get(0).getArea()).isEqualTo(BigDecimal.valueOf(652090.00));
        assertThat(result.get(0).getCountryCode2()).isEqualTo("AF");
    }

    @Test
    void languagesListForValidCountryTest() {
        List<LanguageByCountryDto> mockLanguages = getLanguages();

        when(countryMapper.languagesByCountryId(COUNTRY_ID)).thenReturn(mockLanguages);

        List<LanguageByCountryDto> result = countryService.listLanguages(COUNTRY_ID);

        assertThat(result).hasSize(5);
        assertThat(result.get(0).getLanguage()).isEqualTo("Balochi");
        assertThat(result.get(1).getLanguage()).isEqualTo("Dari");


        verify(countryValidator, times(1)).validateExists(COUNTRY_ID);
        verify(countryMapper, times(1)).languagesByCountryId(COUNTRY_ID);
    }


    @Test
    void languagesListForUnValidCountryTest() {
        doThrow(new IllegalArgumentException("Country not found"))
                .when(countryValidator).validateExists(COUNTRY_ID_UNVALID);

        try {
            countryService.listLanguages(COUNTRY_ID_UNVALID);
        } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage()).isEqualTo("Country not found");
        }

        verify(countryValidator, times(1)).validateExists(COUNTRY_ID_UNVALID);
        verifyNoInteractions(countryMapper);

    }
}
