package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Grimpeur;
import com.vins.climbingFriends.repository.IGrimpeurRepository;

import com.vins.climbingFriends.services.GrimpeurServiceImpl;
import org.checkerframework.checker.units.qual.A;
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
    private GrimpeurServiceImpl grimpeurService;

    @Autowired
    private IGrimpeurRepository grimpeurRepository;

    @Test
    public void givenGrimpeurRepository_whenSaveRetreiveGrimpeur_thenOk(){
        Grimpeur grimpeur = grimpeurRepository.save(new Grimpeur());
        Optional<Grimpeur> foundGrimpeur = grimpeurRepository.findById(grimpeur.getId());

        assertThat(foundGrimpeur).isNotNull();
        assertThat(grimpeur.getId()).isEqualTo(foundGrimpeur.get().getId());
        grimpeurRepository.delete(grimpeur);
    }

    @Test
    public void givenGrimpeurRepository_whenDeleteGrimpeur_thenOk(){
        Grimpeur grimpeur = grimpeurRepository.save(new Grimpeur());
        assertThat(grimpeurRepository.count()).isEqualTo(1);

        grimpeurRepository.deleteById(grimpeur.getId());
        assertThat(grimpeurRepository.count()).isEqualTo(0);
    }

    @Test
    public void givenGrimpeurService_whenFindByPseudo_thenReturnGrimpeur(){
        Grimpeur grimpeur = new Grimpeur();
        grimpeur.setPseudo("martin");
        grimpeur.setEmail("martin@gmail.com");
        grimpeurRepository.save(grimpeur);
        assertThat(grimpeur.getPseudo()).isEqualTo("martin");

        Grimpeur foundByPseudo = grimpeurService.findByPseudo("martin");
        assertThat(foundByPseudo.getEmail()).isEqualTo("martin@gmail.com");
        grimpeurRepository.delete(grimpeur);

    }
}
