package com.qualco.countries.mapper;

import com.qualco.countries.dto.CountryDto;
import com.qualco.countries.dto.LanguageByCountryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CountryMapper {
    List<CountryDto> listCountries();
    List<LanguageByCountryDto> languagesByCountryId(@Param("countryId") int countryId);
    Integer existsById(@Param("countryId") int countryId);
}
