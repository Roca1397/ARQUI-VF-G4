package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.BankDto;
import com.yobrunox.trabajofinalgrupo4.models.Bank;
import com.yobrunox.trabajofinalgrupo4.models.City;
import com.yobrunox.trabajofinalgrupo4.repository.BankRepository;
import com.yobrunox.trabajofinalgrupo4.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BankService {
    final BankRepository bankRepository;
    final CityRepository cityRepository;

    public BankService(BankRepository bankRepository, CityRepository cityRepository) {
        this.bankRepository = bankRepository;
        this.cityRepository = cityRepository;
    }

    public Bank Add (BankDto bankDto) {
        City city = new City();
        city.setId(bankDto.getCityId());
        Bank bank = new Bank(bankDto.getNameBank(),bankDto.getAddressBank(),bankDto.getPhoneBank(),city);
        return bankRepository.save(bank);
    }
    public java.util.List<BankDto> getAll() {
        java.util.List<Bank> lista = bankRepository.findAll();
        List<BankDto> listaDto = new ArrayList<>();
        BankDto item;
        for(Bank b: lista){
            item = new BankDto(b.getNameBank(),b.getAddressBank(),b.getPhoneBank(),b.getCity().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
}
