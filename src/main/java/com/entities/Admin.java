package com.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="t_Admin_adm")
public class Admin {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adm_id")
    private Long Id;

    @Column(name = "adm_login")
    private String login;
    @Column(name = "adm_password")
    private String pwd;
}
