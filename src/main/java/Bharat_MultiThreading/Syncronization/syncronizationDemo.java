package Bharat_MultiThreading.Syncronization;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class syncronizationDemo {

  public static void main(String[] args) {
    DisplayMessage dm = new DisplayMessage();
    MyThread t1 = new MyThread(dm,"Steve");
    MyThread t2 = new MyThread(dm,"Ravi");

    t1.start();
    t2.start();
  }
}
