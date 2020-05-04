package ch3.q3_06_Animal_Shelter;

public class Cat extends Animal{
  public Cat(String n) {
    super(n);
  }

  public String name() {
    return "Name: " + name;
  }
}