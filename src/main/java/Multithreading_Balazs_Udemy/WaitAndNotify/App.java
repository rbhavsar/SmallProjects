package Multithreading_Balazs_Udemy.WaitAndNotify;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {

  /*
      1. t1 aquires class level lock and print first line
      2. Then wait for other thread ( here t2 ) to start execution
      3. t2 aquires class level lock and print first line
      4. Then notify first thread to execute , as he is done with execution --> notify wake up wait method
      5. t1 execute last line

      Output :
      We are in produce method....
      We are in consume method...
      wait for 3 secs.
      We are AGAIN in produce method...
  */

  static class Processor{
    public void produce() throws InterruptedException{
      synchronized (this){ // Class level intrisinc lock
        System.out.println("We are in produce method....");
        wait();
        System.out.println("We are AGAIN in produce method...");
      }

    }

    public void consume() throws InterruptedException{
      synchronized (this){
        System.out.println("We are in consume method...");
        notify();
        System.out.println("wait for 3 secs.");
        Thread.sleep(3000);
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
