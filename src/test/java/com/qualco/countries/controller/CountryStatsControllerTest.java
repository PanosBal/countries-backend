package com.qualco.countries.controller;

import com.qualco.countries.dto.CountryStatsMaxGdpRatioDto;
import com.qualco.countries.dto.CountryStatsViewDto;
import com.qualco.countries.dto.PageDto;
import com.qualco.countries.mapper.CountryMapper;
import com.qualco.countries.mapper.CountryStatsMapper;
import com.qualco.countries.mapper.RegionMapper;
import com.qualco.countries.service.CountryStatsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.qualco.countries.mock.MockData.getCountryStats;
import static com.qualco.countries.mock.MockData.getCountryStatsMaxGdpRatios;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CountryStatsController.class)
class CountryStatsControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private CountryStatsService countryStatsService;
    @MockBean private CountryMapper countryMapper;
    @MockBean private CountryStatsMapper countryStatsMapper;
    @MockBean private RegionMapper regionMapper;

    @Test
    void getMaxGdpPerPopulationTest() throws Exception {
        List<CountryStatsMaxGdpRatioDto> mockResponse = getCountryStatsMaxGdpRatios();

        when(countryStatsService.getMaxGdpPerPopulation()).thenReturn(mockResponse);

        mockMvc.perform(get("/api/stats/max-gdp-per-pop")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Aruba"))
                .andExpect(jsonPath("$[0].gdp").value(2745251397L))
                .andExpect(jsonPath("$[1].name").value("Afghanistan"))
                .andExpect(jsonPath("$[1].gdp").value(20001615789L));
    }

    @Test
    void getCountryStatsTest() throws Exception {
        List<CountryStatsViewDto> content = getCountryStats();

        PageDto<CountryStatsViewDto> page =
                new PageDto<>(content, 0, 2, 10);

        when(countryStatsService.searchStats(1, 1980, 1990, 0, 2)).thenReturn(page);

        mockMvc.perform(get("/api/stats/country-stats")
                        .param("regionId", "1")
                        .param("yearFrom", "1980")
                        .param("yearTo", "1990")
                        .param("page", "0")
                        .param("size", "2")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.page").value(2))
                .andExpect(jsonPath("$.size").value(10))
                .andExpect(jsonPath("$.total").value(0))
                .andExpect(jsonPath("$.items[0].countryName").value("Angola"))
                .andExpect(jsonPath("$.items[0].year").value(1980))
                .andExpect(jsonPath("$.items[1].countryName").value("Angola"))
                .andExpect(jsonPath("$.items[1].year").value(1981));
    }
}

