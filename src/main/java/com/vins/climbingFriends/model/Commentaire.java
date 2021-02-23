package com.vins.climbingFriends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne
    Grimpeur grimpeur;

    @JsonBackReference
    @ManyToOne
    SiteEscalade siteEscalade;

}
