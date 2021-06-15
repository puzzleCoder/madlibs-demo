package io.pantheon.interview.question.madlibsdemo.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MadlibsServiceTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void serviceShouldReturnText() {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port  + "/madlib", String.class)).isNotNull();
	}
	
	@Test
	public void serviceShouldStartWith() {
		assertThat(this.restTemplate.getForEntity("http://localhost:" + port  + "/madlib", String.class)).descriptionText().startsWith("It was a");
	}
}
