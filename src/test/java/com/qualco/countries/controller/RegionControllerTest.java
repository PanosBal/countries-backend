package com.qualco.countries.controller;

import com.qualco.countries.dto.RegionDto;
import com.qualco.countries.mapper.CountryMapper;
import com.qualco.countries.mapper.CountryStatsMapper;
import com.qualco.countries.mapper.RegionMapper;
import com.qualco.countries.service.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.qualco.countries.mock.MockData.getRegions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = RegionController.class)
class RegionControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private RegionService regionService;
    @MockBean private CountryMapper countryMapper;
    @MockBean private CountryStatsMapper countryStatsMapper;
    @MockBean private RegionMapper regionMapper;

    @Test
    void listRegionsTest() throws Exception {
        List<RegionDto> mockRegions = getRegions();

        when(regionService.listRegions()).thenReturn(mockRegions);

        mockMvc.perform(get("/api/regions")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].regionId").value(8))
                .andExpect(jsonPath("$[0].name").value("Antarctica"))
                .andExpect(jsonPath("$[1].regionId").value(9))
                .andExpect(jsonPath("$[1].name").value("Australia and New Zealand"));
    }
}
