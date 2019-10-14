package Multithreading_Balazs_Udemy.ConCurrent_Colletion.blockingqueue.priorityqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
/*
  - It implements blocking queue interface
  - have to implement comparable interface
  - comparable interface determine what will be the order in the queue
  - The priority can be the same compare()==0 case
  - no null items

 */


class FirstWorker implements Runnable{

  private BlockingQueue<String> blockingQueue;

  public FirstWorker(BlockingQueue<String> blockingQueue) {
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {

    try{
      blockingQueue.put("B");
      blockingQueue.put("A");
      Thread.sleep(1000);
      blockingQueue.put("C");
      Thread.sleep(1000);
      blockingQueue.put("H");
      blockingQueue.put("G");
      blockingQueue.put("I");

    }catch (Exception ex){

    }

  }
}


class SecondWorker implements Runnable{

  private BlockingQueue<String> blockingQueue;

  public SecondWorker(BlockingQueue<String> blockingQueue) {
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {

    try{
      while(!blockingQueue.isEmpty()) {
        System.out.println(blockingQueue.take());
        Thread.sleep(1000);
      }
     }catch (Exception ex){

    }

  }
}

public class AppPriorityQueue {

  public static void main(String[] args) {
    BlockingQueue<String> queue = new PriorityBlockingQueue<>();
    new Thread(new FirstWorker(queue)).start();
    new Thread(new SecondWorker(queue)).start();
  }

}
