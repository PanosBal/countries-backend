package com.qualco.countries.service;

import com.qualco.countries.dto.RegionDto;
import com.qualco.countries.mapper.RegionMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.qualco.countries.mock.MockData.getRegions;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class RegionServiceTest {

    private RegionMapper regionMapper;
    private RegionService regionService;

    @BeforeEach
    void setUp() {
        regionMapper = mock(RegionMapper.class);
        regionService = new RegionService(regionMapper);
    }

    @Test
    void listRegionsTest() {
        List<RegionDto> mockRegions = getRegions();
        when(regionMapper.listRegions()).thenReturn(mockRegions);

        List<RegionDto> result = regionService.listRegions();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName()).isEqualTo("Antarctica");
        assertThat(result.get(1).getName()).isEqualTo("Australia and New Zealand");
    }
}
