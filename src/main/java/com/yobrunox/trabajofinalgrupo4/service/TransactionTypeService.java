package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.TransactionTypeDto;
import com.yobrunox.trabajofinalgrupo4.models.TransactionType;
import com.yobrunox.trabajofinalgrupo4.repository.TransactionTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TransactionTypeService {
    final TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeService(TransactionTypeRepository transactionTypeRepository) {
        this.transactionTypeRepository = transactionTypeRepository;
    }


    public TransactionType Add (TransactionTypeDto transactionTypeDto) {
        TransactionType transactionType = new TransactionType(transactionTypeDto.getDescription());
        return transactionTypeRepository.save(transactionType);
    }
    public java.util.List<TransactionTypeDto> getAll() {
        java.util.List<TransactionType> lista = transactionTypeRepository.findAll();
        List<TransactionTypeDto> listaDto = new ArrayList<>();
        TransactionTypeDto item;
        for(TransactionType tt: lista){
            item = new TransactionTypeDto(tt.getDescription());
            listaDto.add(item);
        }
        return listaDto;
    }
}
