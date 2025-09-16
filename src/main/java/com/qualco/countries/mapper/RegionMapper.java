package com.qualco.countries.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.qualco.countries.dto.RegionDto;

import java.util.List;

@Mapper
public interface RegionMapper {
    List<RegionDto> listRegions();
}
