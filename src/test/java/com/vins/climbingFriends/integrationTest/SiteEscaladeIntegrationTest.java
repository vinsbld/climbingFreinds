package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.SiteEscalade;
import com.vins.climbingFriends.repository.ISiteEscaladeRepository;
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
public class SiteEscaladeIntegrationTest {

    @Autowired
    private ISiteEscaladeRepository siteEscaladeRepository;

    @Test
    public void givenSiteEscaladeRepository_whenSaveAndRetreiveSiteEscalade_thenOK(){
        SiteEscalade siteEscalade = siteEscaladeRepository.save(new SiteEscalade());
        Optional<SiteEscalade> foundSite = siteEscaladeRepository.findById(siteEscalade.getId());

        assertThat(foundSite).isNotNull();
        assertThat(siteEscalade.getId()).isEqualTo(foundSite.get().getId());
    }
}
