package com.vins.climbingFriends;

import com.vins.climbingFriends.utils.H2JpaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.ws.rs.core.Application;

@SpringBootTest(classes = {Application.class, H2JpaConfig.class})
@ActiveProfiles("test")
class ClimbingFriendsApplicationTests {

	@Test
	void contextLoads() {
	}

}
