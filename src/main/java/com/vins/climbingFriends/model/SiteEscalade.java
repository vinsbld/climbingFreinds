package com.vins.climbingFriends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteEscalade implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nomDuSite;

    boolean officiel;

    @OneToMany
    Collection<Secteur> secteurs;

    @OneToMany
    Collection<Commentaire> commentaires;

}
