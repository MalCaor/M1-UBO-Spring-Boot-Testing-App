package com.services.impl;

import com.dtos.SalleDto;
import com.dtos.SalleDto;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.SalleService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class SalleServiceImpl implements SalleService {
    private final com.repositories.SalleRepository SalleRepository;

    public SalleServiceImpl(SalleRepository SalleRepository){
        this.SalleRepository = SalleRepository;
    }

    @Override
    public SalleDto saveSalle(SalleDto SalleDto) {
        // Converts the dto to the Salle entity
        Salle Salle = SalleDtoToEntity(SalleDto);
        // Save the Salle entity
        Salle = SalleRepository.save(Salle);
        // Return the new dto
        return SalleEntityToDto(Salle);
    }

    @Override
    public SalleDto getSalleById(Long SalleId) {
        Salle Salle = SalleRepository.findById(SalleId).orElseThrow(() -> new EntityNotFoundException("Salle not found"));
        return SalleEntityToDto(Salle);
    }

    @Override
    public boolean deleteSalle(Long SalleId) {
        SalleRepository.deleteById(SalleId);
        return true;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> SalleDtos = new ArrayList<>();
        List<Salle> Salles = SalleRepository.findAll();
        Salles.forEach(Salle -> {
            SalleDtos.add(SalleEntityToDto(Salle));
        });
        return SalleDtos;
    }

    /**
     * Map Salle dto to Salle entity
     */
    private SalleDto SalleEntityToDto(Salle Salle){
        SalleDto SalleDto = new SalleDto();
        // TODO : Set
        return SalleDto;
    }

    /**
     * Map Salle entity to Salle dto
     */
    private Salle SalleDtoToEntity(SalleDto SalleDto){
        Salle Salle = new Salle();
        // TODO : Get
        return Salle;
    }
}
