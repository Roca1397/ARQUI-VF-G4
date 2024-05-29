package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.CityDto;
import com.yobrunox.trabajofinalgrupo4.models.City;
import com.yobrunox.trabajofinalgrupo4.models.Country;
import com.yobrunox.trabajofinalgrupo4.repository.CityRepository;
import com.yobrunox.trabajofinalgrupo4.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    final CityRepository cityRepository;
    final CountryRepository countryRepository;

    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public City Add (CityDto cityDto) {
        Country country = new Country();
        country.setId(cityDto.getCountryId());
        City city = new City(cityDto.getNameCity(),country);
        return cityRepository.save(city);
    }

    public java.util.List<CityDto> getAll() {
        java.util.List<City> lista = cityRepository.findAll();
        List<CityDto> listaDto = new ArrayList<>();
        CityDto item;
        for(City c: lista){
            item = new CityDto(c.getNameCity(),c.getCountry().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
