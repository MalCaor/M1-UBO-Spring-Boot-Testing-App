package com.services.impl;

import com.dtos.BilletDto;
import com.dtos.BilletDto;
import com.entities.Billet;
import com.repositories.BilletRepository;
import com.services.BilletService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BilletServiceImpl implements BilletService {
    private final BilletRepository BilletRepository;

    public BilletServiceImpl(BilletRepository BilletRepository){
        this.BilletRepository = BilletRepository;
    }

    @Override
    public BilletDto saveBillet(BilletDto BilletDto) {
        // Converts the dto to the Billet entity
        Billet Billet = BilletDtoToEntity(BilletDto);
        // Save the Billet entity
        Billet = BilletRepository.save(Billet);
        // Return the new dto
        return BilletEntityToDto(Billet);
    }

    @Override
    public BilletDto getBilletById(Long BilletId) {
        Billet Billet = BilletRepository.findById(BilletId).orElseThrow(() -> new EntityNotFoundException("Billet not found"));
        return BilletEntityToDto(Billet);
    }

    @Override
    public boolean deleteBillet(Long BilletId) {
        BilletRepository.deleteById(BilletId);
        return true;
    }

    @Override
    public List<BilletDto> getAllBillets() {
        List<BilletDto> BilletDtos = new ArrayList<>();
        List<Billet> Billets = BilletRepository.findAll();
        Billets.forEach(Billet -> {
            BilletDtos.add(BilletEntityToDto(Billet));
        });
        return BilletDtos;
    }

    /**
     * Map Billet dto to Billet entity
     */
    private BilletDto BilletEntityToDto(Billet Billet){
        BilletDto BilletDto = new BilletDto();
        // TODO : Set
        return BilletDto;
    }

    /**
     * Map Billet entity to Billet dto
     */
    private Billet BilletDtoToEntity(BilletDto BilletDto){
        Billet Billet = new Billet();
        // TODO : Get
        return Billet;
    }
}
