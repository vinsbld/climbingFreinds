package com.vins.climbingFriends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonManagedReference
    @ManyToOne
    Grimpeur grimpeur;

    @JsonManagedReference
    @ManyToOne
    Topo topo;

}
