package MultiThreading.T4;

/**
 * @author rbhavsar
 * Created on 9/25/18.
 */
//https://www.youtube.com/watch?v=RH7G-N2pa8M&index=8&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW

class Counter{
  int count;

  public synchronized void increment(){ // When two thread increment concurrently, After synchronized when t1 is working with this method t2 has to wait and viceversa
    count++; //count = count + 1
  }
}


public class SyncDemo {

  public static void main(String[] args) throws Exception{
    Counter counter = new Counter();

    Thread t1 = new Thread(new Runnable() {

      public void run() {
        for(int i=1;i<=1000;i++){
          counter.increment();
        }
      }
    });

    Thread t2 = new Thread(new Runnable() {

      public void run() {
        for(int i=1;i<=1000;i++){
          counter.increment();
        }
      }
    });
    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println("Count "+counter.count);
  }

}
