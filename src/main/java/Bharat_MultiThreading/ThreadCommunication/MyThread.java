package Bharat_MultiThreading.ThreadCommunication;

/**
 * @author rbhavsar
 * Created on 12/16/18.
 */
public class MyThread extends Thread{

  int total;

  @Override
  public void run(){
    System.out.println("Child Thread is calculating the sum:");

    synchronized (this) {
      for (int i = 0; i <= 100; i++) {
        total += i;
      }
      this.notify();
    }
  }
}
