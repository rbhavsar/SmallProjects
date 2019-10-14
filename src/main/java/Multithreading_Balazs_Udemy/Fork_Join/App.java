package Multithreading_Balazs_Udemy.Fork_Join;

import java.util.concurrent.ForkJoinPool;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */

/*
Fork() - Asynchronously execute the given task in the pool , We can call this as Recursive Action & Recursive Task <T>

Join() - Return the result of computation when it is done.

Invoke() - Execute the given task + return the result upon completion !

*/

public class App {

  public static void main(String[] args) {
    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors()); // as many thread = available processor
    SimpleRecusiveAction simpleRecusiveAction = new SimpleRecusiveAction(120);
    simpleRecusiveAction.invoke();


  }
}
