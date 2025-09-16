package com.qualco.countries.service;

import com.qualco.countries.dto.CountryStatsMaxGdpRatioDto;
import com.qualco.countries.dto.CountryStatsViewDto;
import com.qualco.countries.dto.PageDto;
import com.qualco.countries.mapper.CountryStatsMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.qualco.countries.mock.MockData.getCountryStats;
import static com.qualco.countries.mock.MockData.getCountryStatsMaxGdpRatios;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CountryStatsServiceTest {

    private CountryStatsMapper countryStatsMapper;
    private CountryStatsService countryStatsService;

    @BeforeEach
    void setUp() {
        countryStatsMapper = mock(CountryStatsMapper.class);
        countryStatsService = new CountryStatsService(countryStatsMapper);
    }

    @Test
    void getMaxGdpPerPopulationTest() {
        List<CountryStatsMaxGdpRatioDto> mockList = getCountryStatsMaxGdpRatios();
        when(countryStatsMapper.findMaxGdpPerPopulation()).thenReturn(mockList);

        List<CountryStatsMaxGdpRatioDto> result = countryStatsService.getMaxGdpPerPopulation();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Aruba");
        assertThat(result.get(1).getName()).isEqualTo("Afghanistan");
        assertThat(result.get(0).getPopulation()).isEqualTo(101358L);
        assertThat(result.get(1).getPopulation()).isEqualTo(31161376L);
    }


    @Test
    void getStatsTest() {
        Integer regionId = 3;
        Integer yearFrom = 2000;
        Integer yearTo = 2010;
        int page = 1;
        int size = 2;
        int offset = page * size;

        List<CountryStatsViewDto> mockItems = getCountryStats();

        when(countryStatsMapper.countCountryStats(regionId, yearFrom, yearTo)).thenReturn(10);
        when(countryStatsMapper.findCountryStats(regionId, yearFrom, yearTo, size, offset))
                .thenReturn(mockItems);

        PageDto<CountryStatsViewDto> result =
                countryStatsService.searchStats(regionId, yearFrom, yearTo, page, size);

        assertThat(result.getTotal()).isEqualTo(10);
        assertThat(result.getPage()).isEqualTo(1);
        assertThat(result.getSize()).isEqualTo(2);
        assertThat(result.getItems()).hasSize(2);
        assertThat(result.getItems().get(0).getContinentName()).isEqualTo("Africa");
        assertThat(result.getItems().get(1).getContinentName()).isEqualTo("Africa");
        assertThat(result.getItems().get(0).getGdp()).isEqualTo(5930503401L);
        assertThat(result.getItems().get(1).getGdp()).isEqualTo(5550483036L);
    }
}
