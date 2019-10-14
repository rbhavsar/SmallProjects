package DesignPattern.BuilderPattern1;

/**
 * @author rbhavsar
 * Created on 11/7/18.
 */

/*
Builder has to be static class . has to be nested class . can use private consturcotr of computer class
Builder contains all variables present in class and setter method of the same.
Builder has build() method - Which return Computer object

Don't want to pass each parameters in constructor
Main Class contains builder constructor !


 */

public class Computer {

  //Required Parameters
  private String RAM;
  private String HDD;
  private String CPU;


  //Optional parameters
  private boolean isGraphicalCardEnabled;
  private boolean isBluetoothEnabled;

  private Computer(Builder builder) {
    this.CPU=builder.CPU;
    this.RAM=builder.RAM;
    this.HDD=builder.HDD;
    this.isGraphicalCardEnabled=builder.isGraphicalCardEnabled;
    this.isBluetoothEnabled=builder.isBluetoothEnabled;

  }

  //Create builder class for Computer
  public static class Builder{

    //Required Parameters
    private String RAM;
    private String HDD;
    private String CPU;


    //Optional parameters - create setter for optional
    private boolean isGraphicalCardEnabled;
    private boolean isBluetoothEnabled;

    public Builder(String CPU,String HDD,String RAM){
      this.RAM=RAM;
      this.CPU=CPU;
      this.HDD=HDD;
    }

    public Builder setGraphicalCardEnabled(boolean graphicalCardEnabled) {
      this.isGraphicalCardEnabled = graphicalCardEnabled;
      return this;
    }

    public Builder setBluetoothEnabled(boolean bluetoothEnabled) {
      isBluetoothEnabled = bluetoothEnabled;
      return this;
    }

    //get instance of computer
    public Computer build(){
      return new Computer(this);
    }


  }









}
