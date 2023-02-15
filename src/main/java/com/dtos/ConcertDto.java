package com.dtos;

import com.entities.Groupe;
import com.entities.Salle;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ConcertDto {
    private long id;
    private List<Groupe> groupes;
    private Date dateDeb;
    private Date dateFin;
    private Salle salle;
    private double prix;
}
