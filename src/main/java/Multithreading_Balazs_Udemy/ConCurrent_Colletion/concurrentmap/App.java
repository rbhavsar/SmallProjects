package Multithreading_Balazs_Udemy.ConCurrent_Colletion.concurrentmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rbhavsar
 * Created on 4/14/19.
 */

/*
- Thread safe collection
- t1 --> put
- t2 --> get

 */


class FirstWorker implements Runnable{
  private ConcurrentHashMap<String,Integer> map;

  public FirstWorker(ConcurrentHashMap<String,Integer> map){
    this.map=map;
  }


  @Override
  public void run() {
    try{
      System.out.println("Inserting B");
      map.put("B",1);
      System.out.println("Inserting H");
      map.put("H",4);
      Thread.sleep(1000);
      System.out.println("Inserting F");
      map.put("F",5);
      System.out.println("Inserting E");
      map.put("E",3);
      Thread.sleep(1000);
      System.out.println("Inserting C");
      map.put("C",2);
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}

class SecondWorker implements Runnable{
  private ConcurrentHashMap<String,Integer> map;

  public SecondWorker(ConcurrentHashMap<String,Integer> map){
    this.map=map;
  }


  @Override
  public void run() {
    try{
      //Thread.sleep(1000);
      System.out.println(map.get("H"));
      //Thread.sleep(1000);
      System.out.println(map.get("B"));
      System.out.println(map.get("C"));
    }catch (Exception ex){
      ex.printStackTrace();
    }
  }
}

public class App {

  public static void main(String[] args) {
    ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
    new Thread(new FirstWorker(map)).start();
    new Thread(new SecondWorker(map)).start();


  }

}
