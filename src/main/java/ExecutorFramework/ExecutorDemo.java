package ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rbhavsar
 * Created on 12/16/18.
 */
public class ExecutorDemo {

  public static void main(String[] args) {
    CheckProcessorTask[] cps = {new CheckProcessorTask("ATM"),new CheckProcessorTask("Bank"),
    new CheckProcessorTask("Mobile"),new CheckProcessorTask("Web")};

    ExecutorService service = Executors.newFixedThreadPool(2); //2 threads are created in thread pool
    for(CheckProcessorTask checkProcessorTask:cps){
      service.submit(checkProcessorTask);
    }

    service.shutdown();
  }
}
