package com.services;

import com.dtos.ConcertDto;

import java.util.List;

public interface ConcertService {
    /**
     * Sauve a Concert
     */
    ConcertDto saveConcert(ConcertDto ConcertDto);

    /**
     * Get a Concert by it's id
     */
    ConcertDto getConcertById(Long ConcertId);

    /**
     * Delete a Concert by it's id
     */
    boolean deleteConcert(Long ConcertId);

    /**
     * Get all the Concerts
     */
    List<ConcertDto> getAllConcerts();
}
