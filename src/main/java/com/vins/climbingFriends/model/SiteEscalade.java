package com.vins.climbingFriends.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class SiteEscalade implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nomDuSite;

    boolean officiel;
}
