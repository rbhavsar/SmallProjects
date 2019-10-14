package Bharat_MultiThreading.ThreadCommunication;

/**
 * @author rbhavsar
 * Created on 12/16/18.
 */
public class MainThread {

  public static void main(String[] args) {
    MyThread t = new MyThread();
    t.start();

    synchronized (t) {
      try {
        System.out.println("Main thread going to wait");
        t.wait();
        System.out.println("Main thread notified");
        System.out.println("total:" + t.total);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}
