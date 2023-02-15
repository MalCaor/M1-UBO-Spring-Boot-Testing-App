package com.services.impl;

import com.dtos.GroupeDto;
import com.dtos.GroupeDto;
import com.entities.Groupe;
import com.repositories.GroupeRepository;
import com.services.GroupeService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GroupeServiceImpl implements GroupeService {
    private final com.repositories.GroupeRepository GroupeRepository;

    public GroupeServiceImpl(GroupeRepository GroupeRepository){
        this.GroupeRepository = GroupeRepository;
    }

    @Override
    public GroupeDto saveGroupe(GroupeDto GroupeDto) {
        // Converts the dto to the Groupe entity
        Groupe Groupe = GroupeDtoToEntity(GroupeDto);
        // Save the Groupe entity
        Groupe = GroupeRepository.save(Groupe);
        // Return the new dto
        return GroupeEntityToDto(Groupe);
    }

    @Override
    public GroupeDto getGroupeById(Long GroupeId) {
        Groupe Groupe = GroupeRepository.findById(GroupeId).orElseThrow(() -> new EntityNotFoundException("Groupe not found"));
        return GroupeEntityToDto(Groupe);
    }

    @Override
    public boolean deleteGroupe(Long GroupeId) {
        GroupeRepository.deleteById(GroupeId);
        return true;
    }

    @Override
    public List<GroupeDto> getAllGroupes() {
        List<GroupeDto> GroupeDtos = new ArrayList<>();
        List<Groupe> Groupes = GroupeRepository.findAll();
        Groupes.forEach(Groupe -> {
            GroupeDtos.add(GroupeEntityToDto(Groupe));
        });
        return GroupeDtos;
    }

    /**
     * Map Groupe dto to Groupe entity
     */
    private GroupeDto GroupeEntityToDto(Groupe Groupe){
        GroupeDto GroupeDto = new GroupeDto();
        // TODO : Set
        return GroupeDto;
    }

    /**
     * Map Groupe entity to Groupe dto
     */
    private Groupe GroupeDtoToEntity(GroupeDto GroupeDto){
        Groupe Groupe = new Groupe();
        // TODO : Get
        return Groupe;
    }
}
