package Util;

/**
 * @author rbhavsar
 * Created on 4/2/19.
 */
public class Windsor {
  public enum AWS_ENVIRONMENT {
    AUTO, ADE, STAGE, PROD;

    static public AWS_ENVIRONMENT lookup(String env, AWS_ENVIRONMENT defaultValue) {
      try {
        return AWS_ENVIRONMENT.valueOf(env);
      } catch (IllegalArgumentException ex) {
        return defaultValue;
      }
    }

  }
}
