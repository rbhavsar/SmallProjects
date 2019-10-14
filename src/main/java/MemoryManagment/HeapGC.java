package MemoryManagment;

import java.util.ArrayList;

/**
 * @author rbhavsar
 * Created on 4/6/19.
 */

//Run with VM option --> -Xmx10m -verbose:gc
  /*
  [GC (Allocation Failure)  3433K->1321K(9728K), 0.0003368 secs]
[GC (Allocation Failure)  3369K->1321K(9728K), 0.0002822 secs]
[GC (Allocation Failure)  3369K->1353K(9728K), 0.0003023 secs]
   */

public class HeapGC {
  public static void main(String[] args) {
    ArrayList<Customer> customers = new ArrayList<Customer>();
    while(true){
      Customer c = new Customer("Michael");
      customers.add(c);
      //System.out.println(c);
      if(customers.size()>100){
        for(int i=0;i<10;i++){
          customers.remove(i);
        }
      }
    }
  }
}
