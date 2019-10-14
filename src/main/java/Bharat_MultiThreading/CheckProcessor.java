package Bharat_MultiThreading;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class CheckProcessor implements Runnable {

  public static void main(String[] args) {
    CheckProcessor cp = new CheckProcessor();
    Thread t = new Thread(cp);
    t.start();
  }


  @Override
  public void run() {
    System.out.println("Process the checks");
  }
}
