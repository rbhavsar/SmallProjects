package Bharat_MultiThreading.Syncronization;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class MyThread extends Thread {

  DisplayMessage dm;
  String name;

  MyThread(DisplayMessage dm,String name){
    this.dm = dm;
    this.name = name;
  }

  public void run(){
    dm.sayHello(name);
  }
}
