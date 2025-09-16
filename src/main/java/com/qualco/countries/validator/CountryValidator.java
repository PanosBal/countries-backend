package com.qualco.countries.validator;

import com.qualco.countries.exception.ResourceNotFoundException;
import com.qualco.countries.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CountryValidator {

    private final CountryMapper countryMapper;

    public void validateExists(int countryId) {
        Integer exists = countryMapper.existsById(countryId);
        if (exists == null || exists == 0) {
            throw new ResourceNotFoundException("Country with id " + countryId + " does not exist");
        }
    }
}
