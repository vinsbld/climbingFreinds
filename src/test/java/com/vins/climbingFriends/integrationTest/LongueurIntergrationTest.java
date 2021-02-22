package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Longueur;
import com.vins.climbingFriends.repository.ILongueurRepository;
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
public class LongueurIntergrationTest {

    @Autowired
    private ILongueurRepository longueurRepository;

    @Test
    public void givenSitelongueurRepository_whenSaveAndRetreiveLongueur_thenOK(){
        Longueur longueur = longueurRepository.save(new Longueur());
        Optional<Longueur> foundLongueur = longueurRepository.findById(longueur.getId());

        assertThat(foundLongueur).isNotNull();
        assertThat(longueur.getId()).isEqualTo(foundLongueur.get().getId());
    }
}
