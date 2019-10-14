package Bharat_MultiThreading;

/**
 * @author rbhavsar
 * Created on 12/15/18.
 */
public class SingleThreaded {

  public static void main(String[] args) {
    SingleThreaded st = new SingleThreaded();
    st.printNumber();

    for(int i=0;i<=200;i++){
      System.out.println("i: "+i);
    }
  }


  void printNumber(){
    for(int i=0;i<=200;i++){
      System.out.println("i: "+i);
    }
  }
}
