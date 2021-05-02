package com.oreilly.demo.entities;

import java.util.Objects;

public class Greeting {

  private String message;

  public Greeting() {
  }

  public Greeting(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Greeting greetings = (Greeting) o;
    return Objects.equals(message, greetings.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message);
  }

  @Override
  public String toString() {
    return "Greetings{" +
        "message='" + message + '\'' +
        '}';
  }
}
