package com.vins.climbingFriends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Topo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private String lieu;

    private Date dateDeParution;

    private Boolean disponible;

    @ManyToOne
    Grimpeur grimpeur;

    @OneToMany
    Collection<Reservation> reservations;

}
