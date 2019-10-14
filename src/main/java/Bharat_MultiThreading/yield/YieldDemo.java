package Bharat_MultiThreading.yield;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class YieldDemo {
  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();

    for(int i=0;i<=10;i++){
      System.out.println("Main Thread");
    }
  }
}
