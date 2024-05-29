package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.CountryDto;
import com.yobrunox.trabajofinalgrupo4.models.Country;
import com.yobrunox.trabajofinalgrupo4.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authenticate")
public class CountryController {
    final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/crear")
    public ResponseEntity<Country> Add (@RequestBody CountryDto countryDto) {
        return new ResponseEntity<>(countryService.Add(countryDto), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CountryDto>> getAll(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }
}

