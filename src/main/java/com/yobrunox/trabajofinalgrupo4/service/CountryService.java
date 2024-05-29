package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.CountryDto;
import com.yobrunox.trabajofinalgrupo4.models.Country;
import com.yobrunox.trabajofinalgrupo4.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country Add (CountryDto countryDto) {
        Country country = new Country(countryDto.getNameCountry());
        return countryRepository.save(country);
    }
    public java.util.List<CountryDto> getAll() {
        java.util.List<Country> lista = countryRepository.findAll();
        List<CountryDto> listaDto = new ArrayList<>();
        CountryDto item;
        for(Country c: lista){
            item = new CountryDto(c.getNameCountry());
            listaDto.add(item);
        }
        return listaDto;
    }
}
