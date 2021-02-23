package com.vins.climbingFriends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SiteEscalade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomDuSite;

    boolean officiel;


    @JsonManagedReference
    @ManyToOne
    Grimpeur grimpeur;

    @JsonBackReference
    @OneToMany(mappedBy ="siteEscalade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Secteur> secteurs;

    @JsonBackReference
    @OneToMany(mappedBy = "siteEscalade", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Collection<Commentaire> commentaires;

}
