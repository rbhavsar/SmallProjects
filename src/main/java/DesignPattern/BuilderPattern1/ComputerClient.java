package DesignPattern.BuilderPattern1;

/**
 * @author rbhavsar
 * Created on 11/7/18.
 */
public class ComputerClient {

  public static void main(String[] args) {
    Computer build = new Computer.Builder("", "", "").build();


    Computer build1 = new Computer.Builder("", "", "").setBluetoothEnabled(true).build();
  }
}
