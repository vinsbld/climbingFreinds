package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Grimpeur;
import com.vins.climbingFriends.repository.IGrimpeurRepository;

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
public class GrimpeurIntegrationTest {

    @Autowired
    private IGrimpeurRepository grimpeurRepository;

    @Test
    public void givenGrimpeurRepository_whenSaveAndRetreiveGrimpeur_thenOk(){
        Grimpeur grimpeur = grimpeurRepository.save(new Grimpeur());
        Optional<Grimpeur> foundGrimpeur = grimpeurRepository.findById(grimpeur.getId());

        assertThat(foundGrimpeur).isNotNull();
        assertThat(grimpeur.getId()).isEqualTo(foundGrimpeur.get().getId());
    }
}
