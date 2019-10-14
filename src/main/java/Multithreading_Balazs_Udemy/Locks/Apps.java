package Multithreading_Balazs_Udemy.Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class Apps {


  /*
  ReentrantLock --> it has same behavior as "synchronized approach"
  And it has some additional feature

  new ReentrantLock(boolean fairnessParameter) --> if fairnessParameter = true
  Logest waiting thread will get a lock

  fairness = false --> There is no access order !!

  IMPORTANT - We have to use try catch block , that may throw exceptions
  we can call unlock() in the finally block

   */

  public static int counter = 0;
  private static Lock lock = new ReentrantLock();


  public static void increment() throws Exception {
    lock.lock();
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("thread: "+Thread.currentThread());
        counter++;
        if(Thread.currentThread().getName().equals("Thread-0") && counter==3){
          throw new Exception("Throw exception for thread0.");
        }
      }
    }finally {
      System.out.println("Unlock thread: "+Thread.currentThread().getName());
      lock.unlock();
    }
  }

  public static void main(String[] args) {

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          increment();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          increment();
        } catch (Exception e) {
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

    System.out.println("Final counter: "+counter);

  }

}
