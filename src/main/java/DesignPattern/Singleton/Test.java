package DesignPattern.Singleton;

/**
 * @author rbhavsar
 * Created on 11/2/18.
 */
public class Test {

  public static void main(String[] args) {
    //DateUtil dateUtil = new DateUtil(); -- Can't do

    DateUtil dateUtil1 = DateUtil.getInstance();
    DateUtil dateUtil2 = DateUtil.getInstance();

    System.out.println(dateUtil1==dateUtil2); //true --   singlton works - only one instance created.
  }






}
