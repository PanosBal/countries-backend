package com.qualco.countries.service;

import com.qualco.countries.dto.RegionDto;
import com.qualco.countries.mapper.RegionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionMapper regionMapper;

    public List<RegionDto> listRegions() {
        return regionMapper.listRegions();
    }
}
