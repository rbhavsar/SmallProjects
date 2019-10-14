package DesignPattern.Adapter;

/**
 * @author rbhavsar
 * Created on 10/30/18.
 */
public class WetherAdapter {

  public int findTemp(int zipcode){
    String city = null;

    if(zipcode == 94587){
      city = "sf";
    }
    WeatherFinder finder = new WetherFinderImpl();
    int temp = finder.find(city);
    return temp;
  }

}
