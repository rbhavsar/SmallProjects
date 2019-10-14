package Multithreading_Balazs_Udemy.ConCurrent_Colletion.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */

/*
blocking queue --> interface that represents a queue that is thread safe , put items or take items from it...
For Example : one thread putting items into queue and another thread taking items from it at same time.
we can do it with producer-consumer pattern !

put() --> Putting items to queue
take() --> Taking items to queue
blocking queue is sync
queue is empty --> we don't have to bother about wait/notify .. we will not able to take item.
 */

class FirstWorker implements Runnable{

  private BlockingQueue<Integer> blockingQueue;
  public FirstWorker(BlockingQueue<Integer> blockingQueue){
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {
    int counter = 0;
    while (true){
      try {
        System.out.println("Putting items to queue #"+counter);
        blockingQueue.put(counter);
        counter++;
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


class SecondWorker implements Runnable{

  private BlockingQueue<Integer> blockingQueue;
  public SecondWorker(BlockingQueue<Integer> blockingQueue){
    this.blockingQueue=blockingQueue;
  }

  @Override
  public void run() {
    int counter = 0;
    while (true){
      try {
        //Thread.sleep(5000);
        Integer take = blockingQueue.take();
        System.out.println("Taking item from queue #"+take);
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class App {

  public static void main(String[] args) {

    BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    FirstWorker firstWorker = new FirstWorker(queue);
    SecondWorker secondWorker = new SecondWorker(queue);

    new Thread(firstWorker).start();
    new Thread(secondWorker).start();
  }
}
