package Util;

/**
 * @author rbhavsar
 * Created on 4/2/19.
 */



public class Enumtest {
  public static void main(String[] args) {
      getEnvType("btm.AUTO.aws.access.region");
  }

  private static void getEnvType(String str) {
    str = str.substring(str.indexOf(".")+1);

  }
}
