package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Commentaire;
import com.vins.climbingFriends.repository.ICommentaireRepository;
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
}
