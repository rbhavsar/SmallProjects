package Multithreading_Balazs_Udemy.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */
public class App {

  /*
     1. ExecutorService executorService = Executors.newCachedThreadPool();
     - going to return an executorService that can dynamically reuse threads
     - before starting job -> it is going to check whether there are any thread that can finished the job.. reuse them
     - if there are no waiting thread then it is going to create new one
     - good for the processor.. good solution

     2. ExecutorService executorService = Executors.newFixedThreadPool(N);
     - maximize the number of threads
     - if we want to start a job -> if all threads are busy then we have to wait for one to terminate

     3. ExecutorService executorService = Executors.newSingleThreadExecutor();
     - It uses single thread for the job.
     execute() -> runnable + callable
     submit() -> runnable
   */

static class Worker implements Runnable{

  @Override
  public void run() {
    for(int i=0;i<2;i++){
      System.out.println("Thread: "+Thread.currentThread().getName());
      System.out.println("i: "+i);
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    for(int i=0;i<5;i++){
      executorService.submit(new Worker());
    }
    executorService.shutdown();
  }


}
