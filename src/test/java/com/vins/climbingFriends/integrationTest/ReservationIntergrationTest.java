package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Reservation;
import com.vins.climbingFriends.repository.IReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReservationIntergrationTest {

    @Autowired
    private IReservationRepository reservationRepository;

    @Test
    public void givenReservationRepository_whenSaveAndRetreiveReservation_then_OK(){
        Reservation reservation = reservationRepository.save(new Reservation());
        Optional<Reservation> foundReservation = reservationRepository.findById(reservation.getId());

        assertThat(foundReservation).isNotNull();
        assertThat(reservation.getId()).isEqualTo(foundReservation.get().getId());
    }
}
