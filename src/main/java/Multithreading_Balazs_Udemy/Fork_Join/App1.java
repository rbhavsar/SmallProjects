package Multithreading_Balazs_Udemy.Fork_Join;

import java.util.concurrent.ForkJoinPool;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
public class App1 {

  public static void main(String[] args) {
    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

    SimpleRecursiveTask task = new SimpleRecursiveTask(120);
    System.out.println(pool.invoke(task));
  }
}
