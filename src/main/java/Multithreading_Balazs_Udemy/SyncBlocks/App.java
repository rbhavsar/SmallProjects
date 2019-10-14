package Multithreading_Balazs_Udemy.SyncBlocks;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {

  public static int counter1 = 0;
  public static int counter2 = 0;

  public static Object lock1 = new Object(); // This is not class intrensic lock.. This is just lock created to use before counter++
  public static Object lock2 = new Object();

  public static void add() {
    synchronized (lock1) { // Without this lock this example will work fine, bcs both threads are doing indepedent operation !
      counter1++;
    }
  }

  public static void addAgain() {
    synchronized (lock2) {
      counter2++;
    }
  }

  public static void compute() {
    for (int i = 0; i < 100; i++) {
      add();
      addAgain();
    }
  }


  public static void main(String[] args) {

    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        compute();
      }
    });


    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        compute();
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

    System.out.println("counter1="+counter1+", counter2="+counter2);

  }



}
