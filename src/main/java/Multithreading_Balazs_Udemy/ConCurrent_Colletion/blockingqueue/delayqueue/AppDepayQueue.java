package Multithreading_Balazs_Udemy.ConCurrent_Colletion.blockingqueue.delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */

/*
  - Delayqueue keeps elements internally until a certain delay has expired
  - An Object can be taken from the queue when its delay has expired !
  - Can't place null items in queue
  - queue is sorted, so that object at the head has delay that has expired for the logest time.
  - If no delay has expired , then there is no head element and poll() will return null
  - size() will return the count of both expired and unexpired items !!

 */

public class AppDepayQueue {

  public static void main(String[] args) {
    BlockingQueue<DelayWorker> queue = new DelayQueue<>();
    try{
      queue.put(new DelayWorker(1000,"This is first message..."));
      queue.put(new DelayWorker(10000,"This is second message..."));
      queue.put(new DelayWorker(4000,"This is third message..."));
    }catch (Exception ex){
      ex.printStackTrace();
    }

    while(!queue.isEmpty()){
      try{
        System.out.println(queue.take());
      }catch (InterruptedException ex){
        ex.printStackTrace();
      }
    }
  }


}

class DelayWorker implements Delayed{

  public long getDuration() {
    return duration;
  }

  public void setDuration(long duration) {
    this.duration = duration;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private long duration;
  private String message;

  public DelayWorker(long duration,String message){
    this.duration=System.currentTimeMillis()+duration;
    this.message=message;
  }

  @Override
  public long getDelay(TimeUnit unit) { // How much time we have to wait
    return unit.convert(duration-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
  }

  @Override
  public int compareTo(Delayed otherDelayed) { // How to sort delayed components
    if(this.duration < ((DelayWorker)otherDelayed).getDuration()){
        return -1;
    }
    else if(this.duration > ((DelayWorker)otherDelayed).getDuration()){
      return 1;
    }
    return 0;
  }

  @Override
  public String toString() {
    return this.message;
  }
}
