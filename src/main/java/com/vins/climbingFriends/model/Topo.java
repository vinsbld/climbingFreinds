package com.vins.climbingFriends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Topo implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nom;

    private String description;

    private String lieu;

    private Date dateDeParution;

    private Boolean disponible;

    @JsonManagedReference
    @ManyToOne
    Grimpeur grimpeur;

    @JsonBackReference
    @OneToMany(mappedBy = "topo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Reservation> reservations;

}
