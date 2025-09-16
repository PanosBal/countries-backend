package com.qualco.countries.mapper;

import com.qualco.countries.dto.CountryStatsMaxGdpRatioDto;
import com.qualco.countries.dto.CountryStatsViewDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CountryStatsMapper {
    List<CountryStatsMaxGdpRatioDto> findMaxGdpPerPopulation();

    List<CountryStatsViewDto> findCountryStats(
            @Param("regionId") Integer regionId,
            @Param("yearFrom") Integer yearFrom,
            @Param("yearTo") Integer yearTo,
            @Param("size") int size,
            @Param("offset") int offset);

    int countCountryStats(@Param("regionId") Integer regionId,
                          @Param("yearFrom") Integer yearFrom,
                          @Param("yearTo") Integer yearTo);
}
