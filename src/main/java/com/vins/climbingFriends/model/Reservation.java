package com.vins.climbingFriends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    private Boolean accepter;

    @Enumerated(EnumType.STRING)
    StatusEnum status;

}
