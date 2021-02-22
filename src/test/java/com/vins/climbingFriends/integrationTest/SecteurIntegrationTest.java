package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Secteur;
import com.vins.climbingFriends.repository.ISecteurRepository;
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
public class SecteurIntegrationTest {

    @Autowired
    private ISecteurRepository secteurRepository;

    @Test
    public void givenSecteurRepository_whenSaveAndRetreiveSecteur_thenOK(){
        Secteur secteur = secteurRepository.save(new Secteur());
        Optional<Secteur> foundSecteur = secteurRepository.findById(secteur.getId());

        assertThat(foundSecteur).isNotNull();
        assertThat(secteur.getId()).isEqualTo(foundSecteur.get().getId());
    }
}
