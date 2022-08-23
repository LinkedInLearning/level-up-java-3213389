package com.linkedin.javacodechallenges;

public class Person {

  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setAge(int age) {
    if (age < this.age) {
      System.out.println("You can't make a person younger! New age " +
          " not set");
    } else {
      this.age = age;
    }
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void introduceYourself() {
    System.out.println("Hi, my name is " + getFirstName() + " " +
        getLastName() + " and I'm " + getAge());
  }
}