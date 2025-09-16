package com.qualco.countries.service;

import com.qualco.countries.dto.CountryStatsMaxGdpRatioDto;
import com.qualco.countries.dto.CountryStatsViewDto;
import com.qualco.countries.dto.PageDto;
import com.qualco.countries.mapper.CountryStatsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryStatsService {

    private final CountryStatsMapper countryStatsMapper;

    public List<CountryStatsMaxGdpRatioDto> getMaxGdpPerPopulation() {
        return countryStatsMapper.findMaxGdpPerPopulation();
    }

    public PageDto<CountryStatsViewDto> searchStats(
            Integer regionId, Integer yearFrom, Integer yearTo, int page, int size) {
        int total = countryStatsMapper.countCountryStats(regionId, yearFrom, yearTo);
        int offset = page * size;
        List<CountryStatsViewDto> items =
                countryStatsMapper.findCountryStats(regionId, yearFrom, yearTo, size, offset);
        return new PageDto<>(items, total, page, size);
    }
}
