package com.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Concert {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToMany
    private List<Groupe> groupes;

    private Date dateDeb;
    private Date dateFin;

    @ManyToOne
    private Salle salle;

    private double prix;
}
