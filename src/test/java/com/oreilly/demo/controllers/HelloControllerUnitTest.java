package com.oreilly.demo.controllers;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

class HelloControllerUnitTest {

  @Test
  void sayHello() {
    HelloController controller = new HelloController();
    Model model = new BindingAwareModelMap();
    String result = controller.sayHello("World", model);
    assertAll(
        () -> assertEquals("World", model.asMap().get("user")),
        () -> assertEquals("hello", result)
    );
  }
}