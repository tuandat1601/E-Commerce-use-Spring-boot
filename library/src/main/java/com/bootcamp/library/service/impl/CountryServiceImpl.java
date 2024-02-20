package com.bootcamp.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.library.model.Country;
import com.bootcamp.library.repository.CountryRepository;
import com.bootcamp.library.service.CountryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
}
