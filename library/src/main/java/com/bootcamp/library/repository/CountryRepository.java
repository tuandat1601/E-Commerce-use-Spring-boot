package com.bootcamp.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.library.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
