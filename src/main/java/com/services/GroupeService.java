package com.services;

import com.dtos.GroupeDto;

import java.util.List;

public interface GroupeService {
    /**
     * Sauve a Groupe
     */
    GroupeDto saveGroupe(GroupeDto GroupeDto);

    /**
     * Get a Groupe by it's id
     */
    GroupeDto getGroupeById(Long GroupeId);

    /**
     * Delete a Groupe by it's id
     */
    boolean deleteGroupe(Long GroupeId);

    /**
     * Get all the Groupes
     */
    List<GroupeDto> getAllGroupes();
}
