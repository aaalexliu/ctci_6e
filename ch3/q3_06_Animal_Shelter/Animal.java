package ch3.q3_06_Animal_Shelter;

abstract class Animal {
  private int order;
  protected String name;
  public Animal(String n) {name = n; }
  public void setOrder(int ord) { order = ord; };
  public int getOrder() { return order; }

  public abstract String name();

  public boolean isOlderThan(Animal a) {
    return this.order < a.getOrder();
  }
}