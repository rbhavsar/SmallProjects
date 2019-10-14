package MultiThreading.T1;

/**
 * @author rbhavsar
 * Created on 9/25/18.
 */

class Hi extends Thread{

  public void run(){

    for(int i=1;i<=5;i++){
      System.out.println("Hi");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }

}

class Hello extends Thread{

  public void run() {

    for (int i = 1; i <= 5; i++) {
      System.out.println("Hello");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


}


public class ThreadDemo1 {

  public static void main(String[] args) {

    Hi obj1 = new Hi();
    Hello obj2 = new Hello();

    obj1.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    obj2.start();

  }

}
