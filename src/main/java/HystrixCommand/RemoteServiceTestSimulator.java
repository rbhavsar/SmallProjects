package HystrixCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author rbhavsar
 * Created on 5/17/19.
 */
public class RemoteServiceTestSimulator {

  private long wait;

  RemoteServiceTestSimulator(long wait) throws InterruptedException {
    this.wait = wait;
  }

  String execute() throws InterruptedException {
    Thread.sleep(wait);
    return "Success";
  }

}

class RemoteServiceTestCommand extends HystrixCommand<String> {

  private RemoteServiceTestSimulator remoteService;

  RemoteServiceTestCommand(Setter config, RemoteServiceTestSimulator remoteService) {
    super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
    //super(config);
    this.remoteService = remoteService;
  }

  @Override
  protected String run() throws Exception {
    return remoteService.execute();
  }
}
