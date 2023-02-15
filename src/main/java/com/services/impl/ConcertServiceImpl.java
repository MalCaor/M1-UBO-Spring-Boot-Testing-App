package com.services.impl;

import com.dtos.ConcertDto;
import com.dtos.ConcertDto;
import com.entities.Concert;
import com.entities.Concert;
import com.repositories.ConcertRepository;
import com.services.ConcertService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ConcertServiceImpl implements ConcertService {
    private final com.repositories.ConcertRepository ConcertRepository;

    public ConcertServiceImpl(ConcertRepository ConcertRepository){
        this.ConcertRepository = ConcertRepository;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto ConcertDto) {
        // Converts the dto to the Concert entity
        Concert Concert = ConcertDtoToEntity(ConcertDto);
        // Save the Concert entity
        Concert = ConcertRepository.save(Concert);
        // Return the new dto
        return ConcertEntityToDto(Concert);
    }

    @Override
    public ConcertDto getConcertById(Long ConcertId) {
        Concert Concert = ConcertRepository.findById(ConcertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return ConcertEntityToDto(Concert);
    }

    @Override
    public boolean deleteConcert(Long ConcertId) {
        ConcertRepository.deleteById(ConcertId);
        return true;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> ConcertDtos = new ArrayList<>();
        List<Concert> Concerts = ConcertRepository.findAll();
        Concerts.forEach(Concert -> {
            ConcertDtos.add(ConcertEntityToDto(Concert));
        });
        return ConcertDtos;
    }

    /**
     * Map Concert dto to Concert entity
     */
    private ConcertDto ConcertEntityToDto(Concert Concert){
        ConcertDto ConcertDto = new ConcertDto();
        ConcertDto.setId(Concert.getId());
        ConcertDto.setDateDeb(Concert.getDateDeb());
        ConcertDto.setDateFin(Concert.getDateFin());
        ConcertDto.setGroupes(Concert.getGroupes());
        ConcertDto.setPrix(Concert.getPrix());
        ConcertDto.setSalle(Concert.getSalle());
        return ConcertDto;
    }

    /**
     * Map Concert entity to Concert dto
     */
    private Concert ConcertDtoToEntity(ConcertDto ConcertDto){
        Concert Concert = new Concert();
        Concert.setId(ConcertDto.getId());
        Concert.setDateDeb(ConcertDto.getDateDeb());
        Concert.setDateFin(ConcertDto.getDateFin());
        Concert.setGroupes(ConcertDto.getGroupes());
        Concert.setPrix(ConcertDto.getPrix());
        Concert.setSalle(ConcertDto.getSalle());
        return Concert;
    }
}
