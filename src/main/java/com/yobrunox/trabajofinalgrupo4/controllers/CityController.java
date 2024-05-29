package com.yobrunox.trabajofinalgrupo4.controllers;

import com.yobrunox.trabajofinalgrupo4.dto.User.CityDto;
import com.yobrunox.trabajofinalgrupo4.models.City;
import com.yobrunox.trabajofinalgrupo4.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/authenticate")
public class CityController {
    final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @PostMapping("/CrearCiudad")
    public ResponseEntity<City> Add (@RequestBody CityDto cityDto) {
        return new ResponseEntity<>(cityService.Add(cityDto), HttpStatus.CREATED);
    }

    @GetMapping("/ListaCiudad")
    public ResponseEntity<List<CityDto>> getAll(){
        return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
    }
}
