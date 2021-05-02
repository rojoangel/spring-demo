package com.oreilly.demo.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;


import com.oreilly.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class HelloRestControllerIntegrationTest {

  @Test
  void greetWithoutName(@Autowired TestRestTemplate template) {
    ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
    assertEquals(HttpStatus.OK, entity.getStatusCode());
    assertEquals(APPLICATION_JSON, entity.getHeaders().getContentType());
    Greeting response = entity.getBody();
    if (response != null) {
      assertEquals("Hello, World!", response.getMessage());
    }
  }

  @Test
  void greetWithName(@Autowired TestRestTemplate template) {
    Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
    assertEquals("Hello, Dolly!", response.getMessage());

  }
}