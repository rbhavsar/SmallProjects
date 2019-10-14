package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author rbhavsar
 * Created on 7/20/19.
 */
public class log4jDatabase {

  static Logger logger = LogManager.getLogger(log4jDatabase.class);
  public static void main(String[] args) {
    logger.debug("Debug");
    logger.info("Info");
  }
}
