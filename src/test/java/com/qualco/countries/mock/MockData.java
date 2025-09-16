package com.qualco.countries.mock;

import com.qualco.countries.dto.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MockData {

    public static final int COUNTRY_ID = 1;
    public static final int COUNTRY_ID_UNVALID = 9999999;

    public static List<CountryDto> getCountries() {
        CountryDto country1 = new CountryDto(2,"Afghanistan",BigDecimal.valueOf(652090.00),"AF");
        CountryDto country2 = new CountryDto(5,"Albania",BigDecimal.valueOf(28748.00),"AL");
        return Arrays.asList(country1, country2);
    }

    public static List<LanguageByCountryDto> getLanguages() {
        LanguageByCountryDto language1 = new LanguageByCountryDto("Balochi");
        LanguageByCountryDto language2 = new LanguageByCountryDto("Dari");
        LanguageByCountryDto language3 = new LanguageByCountryDto("Pashto");
        LanguageByCountryDto language4 = new LanguageByCountryDto("Turkmenian");
        LanguageByCountryDto language5 = new LanguageByCountryDto("Uzbek");

        return Arrays.asList(language1, language2, language3, language4, language5);
    }

    public static List<CountryStatsMaxGdpRatioDto> getCountryStatsMaxGdpRatios() {
        CountryStatsMaxGdpRatioDto country1 = new CountryStatsMaxGdpRatioDto(
                "Aruba", "ABW", 2008, 101358L, BigDecimal.valueOf(2745251397L)
        );

        CountryStatsMaxGdpRatioDto country2 = new CountryStatsMaxGdpRatioDto(
                "Afghanistan", "AFG", 2012, 31161376L, BigDecimal.valueOf(20001615789L)
        );

        return Arrays.asList(country1, country2);
    }

    public static List<CountryStatsViewDto> getCountryStats() {
        CountryStatsViewDto country1 = new CountryStatsViewDto(
                "Africa", 3, "Central Africa", "Angola", 1980, 8341289L, 5930503401L
        );

        CountryStatsViewDto country2 = new CountryStatsViewDto(
                "Africa", 3, "Central Africa", "Angola", 1981, 8640446L, 5550483036L
        );

        return Arrays.asList(country1, country2);
    }

    public static List<RegionDto> getRegions() {
        RegionDto region1 = new RegionDto("8", "Antarctica");
        RegionDto region2 = new RegionDto("9", "Australia and New Zealand");
        return Arrays.asList(region1, region2);
    }
}
