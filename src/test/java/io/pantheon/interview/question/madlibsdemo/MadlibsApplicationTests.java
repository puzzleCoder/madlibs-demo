package io.pantheon.interview.question.madlibsdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MadlibsApplicationTests {

	@Autowired
	private MadlibsController controller;
	
	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
