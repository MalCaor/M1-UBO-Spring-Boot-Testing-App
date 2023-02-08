package com.services;

import com.dtos.SalleDto;

import java.util.List;

public interface SalleService {
    /**
     * Sauve a Salle
     */
    SalleDto saveSalle(SalleDto SalleDto);

    /**
     * Get a Salle by it's id
     */
    SalleDto getSalleById(Long SalleId);

    /**
     * Delete a Salle by it's id
     */
    boolean deleteSalle(Long SalleId);

    /**
     * Get all the Salles
     */
    List<SalleDto> getAllSalles();
}
