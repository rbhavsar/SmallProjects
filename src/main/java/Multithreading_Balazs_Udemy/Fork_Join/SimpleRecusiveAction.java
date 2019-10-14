package Multithreading_Balazs_Udemy.Fork_Join;

import java.util.concurrent.RecursiveAction;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
public class SimpleRecusiveAction extends RecursiveAction {

  //added to fork-join pool

  private int simulatedWork;

  public SimpleRecusiveAction(int simulatedWork){
    this.simulatedWork = simulatedWork;
  }
  @Override
  protected void compute() {

    if(simulatedWork>100){
      System.out.println("parallel execution and split tasks: "+simulatedWork);
      SimpleRecusiveAction simpleRecusiveAction1 = new SimpleRecusiveAction(simulatedWork/2);
      SimpleRecusiveAction simpleRecusiveAction2 = new SimpleRecusiveAction(simulatedWork/2);

      simpleRecusiveAction1.fork(); // task will execute asynchronously !
      simpleRecusiveAction2.fork();
    }else{
      System.out.println("No need to parallel execution, sequential algorithm is OK.  "+simulatedWork);
    }
  }
}
