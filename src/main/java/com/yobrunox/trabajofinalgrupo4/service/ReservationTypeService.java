package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.ReservationTypeDto;
import com.yobrunox.trabajofinalgrupo4.models.ReservationType;
import com.yobrunox.trabajofinalgrupo4.repository.ReservationTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationTypeService {
    final ReservationTypeRepository reservationTypeRepository;

    public ReservationTypeService(ReservationTypeRepository reservationTypeRepository) {
        this.reservationTypeRepository = reservationTypeRepository;
    }


    public ReservationType Add (ReservationTypeDto reservationTypeDto) {
        ReservationType reservationType = new ReservationType(reservationTypeDto.getName(),reservationTypeDto.getDescription());
        return reservationTypeRepository.save(reservationType);
    }
    public java.util.List<ReservationTypeDto> getAll() {
        java.util.List<ReservationType> lista = reservationTypeRepository.findAll();
        List<ReservationTypeDto> listaDto = new ArrayList<>();
        ReservationTypeDto item;
        for(ReservationType tr: lista){
            item = new ReservationTypeDto(tr.getName(),tr.getDescription());
            listaDto.add(item);
        }
        return listaDto;
    }
}
