package com.yobrunox.trabajofinalgrupo4.service;

import com.yobrunox.trabajofinalgrupo4.dto.User.DebitCardDto;
import com.yobrunox.trabajofinalgrupo4.models.Bank;
import com.yobrunox.trabajofinalgrupo4.models.DebitCard;
import com.yobrunox.trabajofinalgrupo4.models.Role;
import com.yobrunox.trabajofinalgrupo4.models.Users;
import com.yobrunox.trabajofinalgrupo4.repository.BankRepository;
import com.yobrunox.trabajofinalgrupo4.repository.DebitCardRepository;
import com.yobrunox.trabajofinalgrupo4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DebitCardService {
    final DebitCardRepository debitCardRepository;
    final BankRepository bankRepository;
    final UserRepository userRepository;
    public DebitCardService(DebitCardRepository debitCardRepository, BankRepository bankRepository, UserRepository userRepository) {
        this.debitCardRepository = debitCardRepository;
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    public DebitCard Add (DebitCardDto debitCardDto) {
        Bank bank = new Bank();
        bank.setId(debitCardDto.getBankId());
        Users users = new Users();
        users.setId(debitCardDto.getUserId());
        users.setRole(Role.USER);

        DebitCard debitCard = new DebitCard(debitCardDto.getNumberCard(),debitCardDto.getExpirationDate(),debitCardDto.getCvv(),
                debitCardDto.getPassword(),bank,users);
        return debitCardRepository.save(debitCard);
    }

    public java.util.List<DebitCardDto> getAll() {
        java.util.List<DebitCard> lista = debitCardRepository.findAll();
        List<DebitCardDto> listaDto = new ArrayList<>();
        DebitCardDto item;
        for(DebitCard dc: lista){
            item = new DebitCardDto(dc.getNumberCard(),dc.getExpirationDate(),dc.getCvv(),dc.getPassword(),dc.getBank().getId(),dc.getUser().getId());
            listaDto.add(item);
        }
        return listaDto;
    }
    public DebitCardDto actualizarDatosDebitCard(Integer id, String nuevoNumeroCard, LocalDate nuevaFechaExpiracion, Integer nuevoCvv, String nuevaPassword) {
    DebitCard debitCard = debitCardRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Tarjeta de débito no encontrada con ID: " + id));

    debitCard.setNumberCard(nuevoNumeroCard);
    debitCard.setExpirationDate(nuevaFechaExpiracion);
    debitCard.setCvv(nuevoCvv);
    debitCard.setPassword(nuevaPassword);

    debitCard = debitCardRepository.save(debitCard);

    return new DebitCardDto(
            debitCard.getNumberCard(),
            debitCard.getExpirationDate(),
            debitCard.getCvv(),
            debitCard.getPassword(),
            debitCard.getBank().getId(),
            debitCard.getUser().getId()
    );
    }
    public DebitCardDto getDebitCardById(Integer id) {
        Optional<DebitCard> debitCardOptional = debitCardRepository.getDebitCardByUserId(id);

        if (debitCardOptional.isPresent()) {
            DebitCard debitCard = debitCardOptional.get();
            return new DebitCardDto(
                    debitCard.getNumberCard(),
                    debitCard.getExpirationDate(),
                    debitCard.getCvv(),
                    debitCard.getPassword(),
                    debitCard.getBank().getId(),
                    debitCard.getUser().getId()
            );
        }
        return null;
    }

}
