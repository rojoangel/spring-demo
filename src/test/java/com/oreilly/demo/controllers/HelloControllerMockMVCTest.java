package com.oreilly.demo.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerMockMVCTest {

  @Autowired
  private MockMvc mvc;

  @Test
  void sayHelloWithoutName() throws Exception {
    mvc.perform(get("/hello").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(view().name("hello"))
        .andExpect(model().attribute("user", "World"));
  }

  @Test
  void sayHelooWithName() throws Exception {
    mvc.perform(get("/hello").param("name", "Dolly").accept(MediaType.TEXT_PLAIN))
        .andExpect(status().isOk())
        .andExpect(view().name("hello"))
        .andExpect(model().attribute("user", "Dolly"));
  }
}