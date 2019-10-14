package ExecutorFramework;

/**
 * @author rbhavsar
 * Created on 12/16/18.
 */
public class CheckProcessorTask implements Runnable{

  String name;

  public CheckProcessorTask(String name){
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println(name+" Check Processor has began the processig the check:"+Thread.currentThread().getName());
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(name+" Check Processor has completed processing the check"+Thread.currentThread().getName());

  }
}
