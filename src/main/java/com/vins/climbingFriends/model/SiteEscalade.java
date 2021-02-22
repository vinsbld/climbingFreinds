package com.vins.climbingFriends.model;

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

    @OneToMany
    Collection<Secteur> secteurs;

    @OneToMany
    Collection<Commentaire> commentaires;

}
