package DesignPattern.Singleton;

import java.io.Serializable;

/**
 * @author rbhavsar
 * Created on 11/2/18.
 */
public class DateUtil implements Serializable {

  private static volatile DateUtil instance; //what is volatile

  private DateUtil(){

  }

  //two threads are accessing at same time , t1 is trying to create instance and t2 already - we endup with two instance
  public static DateUtil getInstance(){
    if(instance==null) {
      synchronized (DateUtil.class) {
        if (instance == null) {
          instance = new DateUtil(); //Lazy initialization
        }
      }
    }
    return instance;
  }



}
