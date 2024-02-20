package com.bootcamp.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.library.model.City;
import com.bootcamp.library.repository.CityRepository;
import com.bootcamp.library.service.CityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
