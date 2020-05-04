package ch3.q3_06_Animal_Shelter;

import java.util.LinkedList;

class AnimalQueue {
  LinkedList<Dog> dogs = new LinkedList<Dog>();
  LinkedList<Cat> cats = new LinkedList<Cat>();
  private int order = 0;

  public void enqueue(Animal a) {
    a.setOrder(order);
    order++;

    if (a instanceof Dog) dogs.addLast((Dog) a);
    else if (a instanceof Cat) cats.addLast((Cat) a);
  }

  public int size() {
    return dogs.size() + cats.size();
  }

  public Animal dequeueAny() {
    if (dogs.isEmpty()) return cats.poll();
    if (cats.isEmpty()) return dogs.poll();

    return dogs.peek()
    .isOlderThan(cats.peek()) ? dogs.poll() : cats.poll();
  }

  public Animal dequeueDogs() {
    return dogs.poll();
  }

  public Animal dequeueCats() {
    return cats.poll();
  }
} 