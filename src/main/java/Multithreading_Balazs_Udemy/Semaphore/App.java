package Multithreading_Balazs_Udemy.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author rbhavsar
 * Created on 4/7/19.
 */

/*
  - semaphore maintains a set of permits
  - aquires() -> if permits available then takes it.
  - release() -> adds a permits

  semaphore(int permits,boolean fair)
 */

enum Downloader{

  INSTANCE;
  private Semaphore semaphore = new Semaphore(3,true);

  public void downloadData(){
    try{
      semaphore.acquire();
      download();
    }catch (Exception ex){
      ex.printStackTrace();
    }finally {
      semaphore.release();
    }
  }

  public void download(){
    System.out.println("Thread: "+Thread.currentThread().getName());
    System.out.println("Downloading data...");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

public class App {

  public static void main(String[] args) {
    System.out.println("Starting downloading Data...");
    ExecutorService executorService = Executors.newCachedThreadPool();
    for(int i=0;i<12;i++){
      executorService.execute(new Runnable() {
        @Override
        public void run() {
          Downloader.INSTANCE.downloadData();
        }
      });
    }
    //executorService.shutdown();
  }


}
