package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Voie;
import com.vins.climbingFriends.repository.IVoieRepository;
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
public class VoieIntegrationTest {

    @Autowired
    private IVoieRepository voieRepository;

    @Test
    public void givenVoieRepository_whenSaveAndRetreiveVoie_thenOK(){
        Voie voie = voieRepository.save(new Voie());
        Optional<Voie> foundVoie = voieRepository.findById(voie.getId());

        assertThat(foundVoie).isNotNull();
        assertThat(voie.getId()).isEqualTo(foundVoie.get().getId());
    }
}
