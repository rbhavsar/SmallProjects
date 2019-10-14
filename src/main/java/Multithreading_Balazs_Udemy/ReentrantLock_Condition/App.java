package Multithreading_Balazs_Udemy.ReentrantLock_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {


  static class Processor{

    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();


    public void produce() throws InterruptedException{
      lock.lock(); // Same as sync block
      System.out.println("Started Produce....");
      condition.await(); // Same as wait
      System.out.println("Again in Produce...");
      lock.unlock(); // can call in finally block
    }

    public void consume() throws InterruptedException{
      lock.lock();
      System.out.println("Started Consume...");
      condition.signal(); //Same as notify
      Thread.sleep(200);
      lock.unlock();

    }
  }

  public static void main(String[] args) {
    Processor processor = new Processor();

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          processor.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          processor.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });


    t1.start();
    t2.start();

    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

}
