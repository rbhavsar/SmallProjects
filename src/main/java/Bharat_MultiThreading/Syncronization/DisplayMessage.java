package Bharat_MultiThreading.Syncronization;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class DisplayMessage {

  public void sayHello(String name){
    for(int i=0;i<10;i++){
      System.out.println("How are you : "+name);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
