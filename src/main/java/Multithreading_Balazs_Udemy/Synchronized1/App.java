package Multithreading_Balazs_Udemy.Synchronized1;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {

  private static int counter = 0;

  public static synchronized void increment(){
    counter++;
  }

  public static void process(){
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0;i<100;i++){
          increment();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i=0;i<100;i++){
          increment();
        }
      }
    });

    t1.start();
    t2.start();

    try{
      t1.join();
      t2.join();
    }catch (InterruptedException ex){
      ex.printStackTrace();
    }
  }

  public static void main(String[] args) {
    process();
    System.out.println(counter);
  }
}
