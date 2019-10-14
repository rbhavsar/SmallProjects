package MultiThreading.T2;

//https://www.youtube.com/watch?v=xvXbvrUUGMM&list=PLsyeobzWxl7rmuFYRpkqLanwoG4pQQ7oW&index=3
//We start in runnable interface for that you have to create Thread Object

/**
 * @author rbhavsar
 * Created on 9/25/18.
 */

class Hi implements Runnable{

  public void run(){
    for(int i=1;i<=5;i++){
      System.out.println("Hi");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

class Hello implements Runnable{

  public void run(){
    for(int i=1;i<=5;i++){
      System.out.println("Hello");
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}

public class ThreadDemo {


  public static void main(String[] args) throws Exception {

    Hi obj1=new Hi();
    Hello obj2=new Hello();

    Thread t1 = new Thread(obj1,"Hi Thread"); // link Hi Obj1 with Thread t1
    Thread t2 = new Thread(obj2,"Hello Thread");

   // t1.setName("Hi Thread");
   // t2.setName("Hello Thread");

    System.out.println(t1.getName()); // Thread name
    System.out.println(t2.getName()); // Thread name

    System.out.println(t1.getPriority()); // Priority
    System.out.println(t2.getPriority());// Priority

    // Priority from 1 - 10 , 1 is less priority and 10 is highest
    // Here we are getting 5 for both

    t1.setPriority(Thread.MIN_PRIORITY); // 1
    t2.setPriority(Thread.MAX_PRIORITY); // 10

    System.out.println(t1.getPriority()); // Priority
    System.out.println(t2.getPriority());// Priority

    t1.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t2.start();

    System.out.println(t1.isAlive()); // To check thread is running or not

    t1.join();
    t2.join(); // Main will wait until t1 and t2 finish

    System.out.println(t1.isAlive());// To check thread is running or not

    System.out.println("Bye"); //first t1 start , by the time t2 starts main thread start and print Bye
    //We have to say  hey wait main thread until t1 and t2 finish.

  }

}
