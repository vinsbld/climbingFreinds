package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Commentaire;
import com.vins.climbingFriends.repository.ICommentaireRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CommentaireIntegrationTest {

    @Autowired
    private ICommentaireRepository commentaireRepository;

    @Test
    public void givenCommentaireRepository_whenSaveAndRetreiveCommentaire_thenOK(){
        Commentaire commentaire = commentaireRepository.save(new Commentaire());
        Optional<Commentaire> foundCommentaire = commentaireRepository.findById(commentaire.getId());

        assertThat(foundCommentaire).isNotNull();
        assertThat(commentaire.getId()).isEqualTo(foundCommentaire.get().getId());
    }

    @Test
    public void givenCommentaireRepository_whenDelete_thenOK(){
        Commentaire commentaire_1 = commentaireRepository.save(new Commentaire());
        assertThat(commentaireRepository.count()).isEqualTo(1);

        commentaireRepository.delete(commentaire_1);
        assertThat(commentaireRepository.count()).isZero();

    }
}
