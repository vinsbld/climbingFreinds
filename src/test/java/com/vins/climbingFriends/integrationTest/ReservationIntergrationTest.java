package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Reservation;
import com.vins.climbingFriends.repository.IReservationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
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
