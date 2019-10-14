package Bharat_MultiThreading.InterruptDemo;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class IntDemo {
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();
    t.interrupt();
    System.out.println("End of main method.");
  }
}
