package com.qualco.countries.controller;

import com.qualco.countries.dto.RegionDto;
import com.qualco.countries.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/api/regions")
    public List<RegionDto> listRegions() {
        return regionService.listRegions();
    }
}
