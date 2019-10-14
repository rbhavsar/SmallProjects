package HystrixCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

/**
 * @author rbhavsar
 * Created on 5/17/19.
 */
public class App {

  public static void main(String[] args) throws InterruptedException {
    //System.out.println(new CommandHelloWorld("Bob").execute());

    /*
    And here is our sample client that calls the RemoteServiceTestSimulator.
    The call to the service is isolated and wrapped in the run() method of a HystrixCommand.
    Its this wrapping that provides the resilience we touched upon above:
    */

//    HystrixCommand.Setter config = HystrixCommand
//        .Setter
//        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroup2"));

    //System.out.println(new RemoteServiceTestCommand(new RemoteServiceTestSimulator(100)).execute());

    HystrixCommand.Setter config = HystrixCommand
        .Setter
        .withGroupKey(HystrixCommandGroupKey.Factory.asKey("RemoteServiceGroupTest4"));

    HystrixCommandProperties.Setter commandProperties = HystrixCommandProperties.Setter();
    commandProperties.withExecutionTimeoutInMilliseconds(100); //execution timeout !
    config.andCommandPropertiesDefaults(commandProperties);

    System.out.println(new RemoteServiceTestCommand(config, new RemoteServiceTestSimulator(500000)).execute());
  }

}
