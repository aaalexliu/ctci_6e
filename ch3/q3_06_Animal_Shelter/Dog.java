package ch3.q3_06_Animal_Shelter;

public class Dog extends Animal{
  public Dog(String n) {
    super(n);
  }
  
  public String name() {
    return "Name: " + name;
  }
}