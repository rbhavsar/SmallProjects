package Multithreading_Balazs_Udemy.ConCurrent_Colletion.blockingqueue.priorityqueue1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import com.google.common.base.MoreObjects;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
/*
  - It implements blocking queue interface
  - have to implement comparable interface
  - comparable interface determine what will be the order in the queue
  - The priority can be the same compare()==0 case
  - no null items

 */


class FirstWorker implements Runnable{

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("blockingQueue", blockingQueue)
        .toString();
  }

  private BlockingQueue<Person> blockingQueue;

  public FirstWorker(BlockingQueue<Person> blockingQueue) {
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {

    try{
      blockingQueue.put(new Person(12,"Adam"));
      blockingQueue.put(new Person(15,"Kannan"));
      blockingQueue.put(new Person(28,"Ravi"));
      blockingQueue.put(new Person(50,"Arpit"));
      blockingQueue.put(new Person(30,"Kesav"));
      blockingQueue.put(new Person(19,"Malav"));
      System.out.println("filled blocking queue "+blockingQueue);

    }catch (Exception ex){
      ex.printStackTrace();
    }

  }
}


class SecondWorker implements Runnable{

  private BlockingQueue<Person> blockingQueue;

  public SecondWorker(BlockingQueue<Person> blockingQueue) {
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {

    try{
      Thread.sleep(5000);
      while(!blockingQueue.isEmpty()) {
        System.out.println(blockingQueue.take());
        Thread.sleep(1000);
      }
     }catch (Exception ex){

    }

  }
}

class Person implements Comparable<Person>{

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  private int age;
  private String name;

  public Person(int age,String name){
    this.name = name;
    this.age = age;
  }

  @Override
  public int compareTo(Person otherPerson) {
    return name.compareTo(otherPerson.getName());
  }

  @Override
  public String toString() {
    return name+"-"+age;
  }
}

public class AppPriorityQueue {

  public static void main(String[] args) {
    BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
    new Thread(new FirstWorker(queue)).start();
    new Thread(new SecondWorker(queue)).start();
  }

}
