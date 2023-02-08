package com.services;

import com.dtos.BilletDto;

import java.util.List;

public interface BilletService {
    /**
     * Sauve a Billet
     */
    BilletDto saveBillet(BilletDto BilletDto);

    /**
     * Get a Billet by it's id
     */
    BilletDto getBilletById(Long BilletId);

    /**
     * Delete a Billet by it's id
     */
    boolean deleteBillet(Long BilletId);

    /**
     * Get all the Billets
     */
    List<BilletDto> getAllBillets();
}
