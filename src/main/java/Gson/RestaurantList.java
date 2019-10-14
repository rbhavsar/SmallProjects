package Gson;

import java.util.List;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */
public class RestaurantList {

  //incase of json , Array and list are same . It is just different representation of Java Object.

  public RestaurantList(String name, List<RestaurantMenuItems> items) {
    this.name = name;
    this.items = items;
  }

  String name;
  List<RestaurantMenuItems> items;

  public static class RestaurantMenuItems {

    public RestaurantMenuItems(String name, float price) {
      this.name = name;
      this.price = price;
    }

    String name;
    float price;
  }
}
