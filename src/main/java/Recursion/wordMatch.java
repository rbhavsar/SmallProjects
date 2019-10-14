package Recursion;

import org.apache.commons.lang3.StringUtils;

/**
 * @author rbhavsar
 * Created on 11/25/18.
 */
public class wordMatch {

  public static void main(String[] args) {

    String spaces = null;
    if(StringUtils.isNotBlank(spaces)){
      System.out.println("spaces in if "+spaces);
    }else{
      System.out.println("spaces in else "+"\'\'");
    }

    System.out.println(yoYo("xyyoteyo"));
    printNumber(5);
  }

  private static void printNumber(int number) {
    if(number==0){
      return;
    }else{
      System.out.println("number :"+number);
      printNumber(number-1);
    }
  }

  private static int yoYo(String str) {

    if(str.length()<2){
      return 0;
    }
    if(str.substring(0,2).equals("yo")){
      return 1+ yoYo(str.substring(1));
    }else{
      return yoYo(str.substring(1));
    }

  }
}
