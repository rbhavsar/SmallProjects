package Util;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author rbhavsar
 * Created on 10/4/19.
 */
public class TimerTasksTest {

  public static void main(String[] args) {

    Set<String> list = new HashSet<>();
    list.add("ravi");
    list.add("kinisha");
    System.out.println(list);


    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        System.out.println("Task performed on: " + new Date() + "n" +
            ", Thread's name: " + Thread.currentThread().getName());
        //cancel();
      }
    };
    Timer timer = new Timer("Timer");
    long delay = 1;
    timer.scheduleAtFixedRate(task,delay,1);
    System.out.println("current thread : "+Thread.currentThread().getName());
    timer.cancel();
  }
}
