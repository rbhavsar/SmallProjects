package MultiThreading.T3;

//https://www.youtube.com/watch?v=VDYSgjPxu18&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=4 - Lambda


/**
 * @author rbhavsar
 * Created on 9/25/18.
 */

public class ThreadDemo {

  public static void main(String[] args) {

    Thread t1 = new Thread(() ->{
      for (int i = 1; i <= 5; i++) {
        System.out.println("Hi");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    Thread t2 = new Thread(() -> {
      for (int i = 1; i <= 5; i++) {
        System.out.println("Hello");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    t1.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();
  }

}
