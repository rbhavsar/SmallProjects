package Multithreading_Balazs_Udemy.ProduceConsume;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {

  /*

  */

  static class Processor {

    /*
        1. t1 --> produce --> else --> add value then notify
        2. notify first complete the code in while loop
        3. if condition not satified then again add value
        4. once if condition satified then it wait until second t2 complete. bcs of wait and notifiy t2 will start
        5. t2 will aquires lock and remove elements until if condition and then wait
        6. and notify to t1 thread to start execution

     */


    List<Integer> list = new ArrayList<Integer>();
    public static int LIMIT = 5;
    public static int BOTTOM = 0;
    public static Object lock = new Object();
    public int value = 0;


    public void produce() throws InterruptedException {
      synchronized (lock) {

        while (true) {
          if (list.size() == LIMIT) {
            System.out.println("Wait for removing elements from list...");
            lock.wait();
          } else {
            System.out.println("Adding " + value);
            list.add(value);
            value++;
            lock.notify();
          }
          Thread.sleep(500);
        }
      }

    }

    public void consume() throws InterruptedException {

      synchronized (lock) {
        while (true) {
          if (list.size() == BOTTOM) {
            System.out.println("wait for elements to be add");
            lock.wait();
          } else {
            System.out.println("Removing " + list.remove(--value));
            lock.notify();
          }
          Thread.sleep(500);
        }

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

}
