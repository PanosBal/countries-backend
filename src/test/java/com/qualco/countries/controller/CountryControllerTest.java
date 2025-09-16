package com.qualco.countries.controller;

import com.qualco.countries.mapper.CountryMapper;
import com.qualco.countries.mapper.CountryStatsMapper;
import com.qualco.countries.mapper.RegionMapper;
import com.qualco.countries.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.qualco.countries.mock.MockData.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CountryController.class)
public class CountryControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockBean private CountryService countryService;
    @MockBean private CountryMapper countryMapper;
    @MockBean private CountryStatsMapper countryStatsMapper;
    @MockBean private RegionMapper regionMapper;

    @Test
    void listCountriesTest() throws Exception {
        when(countryService.listCountries()).thenReturn(getCountries());

        mockMvc.perform(get("/api/countries")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Afghanistan"))
                .andExpect(jsonPath("$[1].countryCode2").value("AL"));
        }

    @Test
    void listLanguagesTest() throws Exception {
        when(countryService.listLanguages(1)).thenReturn(getLanguages());

        mockMvc.perform(get("/api/countries/{id}/languages", COUNTRY_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].language").value("Balochi"))
                .andExpect(jsonPath("$[1].language").value("Dari"));
    }
}

