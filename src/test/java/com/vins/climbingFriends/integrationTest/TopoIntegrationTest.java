package com.vins.climbingFriends.integrationTest;

import com.vins.climbingFriends.model.Topo;
import com.vins.climbingFriends.repository.ITopoRepository;
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
public class TopoIntegrationTest {

    @Autowired
    private ITopoRepository topoRepository;

    @Test
    public void givenTopoRepository_whenSaveAndRetreiveTopo_thenOK(){
        Topo topo = topoRepository.save(new Topo());
        Optional<Topo> foundTopo = topoRepository.findById(topo.getId());

        assertThat(foundTopo).isNotNull();
        assertThat(topo.getId()).isEqualTo(foundTopo.get().getId());
    }
}
