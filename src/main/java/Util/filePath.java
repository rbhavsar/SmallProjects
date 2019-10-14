package Util;

import static org.apache.commons.lang.StringEscapeUtils.escapeHtml;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */
public class filePath {

  public static void main(String[] args){
    String str = "\"Test\"*\"Connection\"";
    massage(str);
  }

  private static void massage(String str) {

    String source = "~!@#$%^&*()_+{}|:<>?[]\\;',./-=`";
    String escaped = escapeHtml(source);
  }
}
