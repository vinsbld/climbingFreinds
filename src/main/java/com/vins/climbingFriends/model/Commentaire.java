package com.vins.climbingFriends.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String commentaire;

    private Date date;

    @ManyToOne
    Grimpeur grimpeur;

    @ManyToOne
    SiteEscalade siteEscalade;

}
