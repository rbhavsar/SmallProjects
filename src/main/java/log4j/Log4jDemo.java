package log4j;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author rbhavsar
 * Created on 7/20/19.
 */
public class Log4jDemo {


  static Logger logger = LogManager.getLogger(Log4jDemo.class);

  public static void main(String[] args) {

    //Default --> Error and fatal

    System.out.println("\nThis is logging for hello world \n");
    logger.trace("This is trace message");
    logger.info("This is information message");
    logger.error("This is an error message");
    logger.warn("This is warning message");
    logger.fatal("This is fatal message");
    System.out.println("\n Completed!");
  }
}
