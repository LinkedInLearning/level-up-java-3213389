package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {
  private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(printOut));
  }

  @After
  public void restoreStreams() {
    System.setOut(System.out);
  }

  @Test
  public void personAttributes_firstName() {
    Person person = new Person("Sally", "Mills", 24);
    assertEquals("Sally", person.getFirstName());
    person.setFirstName("Rebecca");
    assertEquals("Rebecca", person.getFirstName());
  }

  @Test
  public void personAttributes_lastName() {
    Person person = new Person("Ann", "Johnson", 10);
    assertEquals("Johnson", person.getLastName());
    person.setLastName("Martin");
    assertEquals("Martin", person.getLastName());
  }

  @Test
  public void personAttributes_age() {
    Person person = new Person("Nancy", "Moore", 89);
    assertEquals(89, person.getAge());
    person.setAge(90);
    assertEquals(90, person.getAge());
  }

  @Test
  public void personAttributes_ageInvalid() {
    Person person = new Person("Marty", "Campbell", 40);
    assertEquals(40, person.getAge());
    person.setAge(30);
    assertEquals(40, person.getAge());
  }

  @Test
  public void personAttributes_introduceYourself() {
    Person person = new Person("Ruby", "Wilson", 56);
    person.introduceYourself();
    assertEquals("Hi, my name is Ruby Wilson and I'm 56\n", printOut.toString());
  }
}
