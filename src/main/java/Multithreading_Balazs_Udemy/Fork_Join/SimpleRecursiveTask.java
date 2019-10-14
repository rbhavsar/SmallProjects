package Multithreading_Balazs_Udemy.Fork_Join;

import java.util.concurrent.RecursiveTask;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */
public class SimpleRecursiveTask extends RecursiveTask<Integer> {

  private int simulatedWork;

  public SimpleRecursiveTask(int simulatedWork){
    this.simulatedWork = simulatedWork;
  }




  @Override
  protected Integer compute() {

    if(simulatedWork>100){
      System.out.println("Parallel execution needed , Huge task"+simulatedWork);
      SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork/2);
      SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork/2);
      task1.fork();
      task2.fork();

      int solution = 0;
      solution += task1.join();
      solution += task2.join();

      return solution;

    }else {
      System.out.println("No need for parallel execution !"+simulatedWork);
      return 2* simulatedWork;
    }
  }
}
