package HystrixCommand;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author rbhavsar
 * Created on 5/17/19.
 */
public class CommandHelloWorld extends HystrixCommand<String> {

  private String name;

  CommandHelloWorld(String name){
    super(HystrixCommandGroupKey.Factory.asKey("Example Group"));
    this.name=name;
  }

  @Override
  protected String run() throws Exception {
    return "Hello " + name + "!";
  }
}


