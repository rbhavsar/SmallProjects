package Bharat_MultiThreading;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class MultiThreaded extends Thread {

  public static void main(String[] args) {
    MultiThreaded mt = new MultiThreaded();
    mt.setPriority(MAX_PRIORITY);
    mt.setName("MT");
    mt.start();


    MultiThreaded mt1 = new MultiThreaded();
    mt1.setPriority(MIN_PRIORITY);
    mt1.setName("MT1");
    mt1.start();

//    Thread thread = Thread.currentThread();
//    System.out.println("Thread Name is "+thread.getName());

//    for(int i=0;i<=10;i++){
//      System.out.println("j: "+i);
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }

  }

  public void run(){
    Thread thread = Thread.currentThread();
    System.out.println("Thread Name is "+thread.getName());

//    for(int i=0;i<=10;i++){
//      System.out.println("i: "+i);
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
  }

}
