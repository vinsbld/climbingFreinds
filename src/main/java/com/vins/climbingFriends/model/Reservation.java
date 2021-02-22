package com.vins.climbingFriends.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private Boolean accepter;

    @Enumerated(EnumType.STRING)
    StatusEnum status;

    @ManyToOne
    Grimpeur grimpeur;

    @ManyToOne
    Topo topo;

}
