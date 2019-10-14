package DesignPattern.Adapter;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class WeatherUI {

  public void showTemp(int zipCode){
    WetherAdapter adapter = new WetherAdapter();
    System.out.println(adapter.findTemp(zipCode));
  }

  public static void main(String[] args) {
    new WeatherUI().showTemp(94587);
  }

}
