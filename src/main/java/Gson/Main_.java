/*

package Gson;

//incase of json , Array and list are same . It is just different representation of Java Object.


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

*/
/**
 * @author rbhavsar
 * Created on 9/2/18.
 *//*


public class Main_ {

  private static final ArrayList<RestaurantList.RestaurantMenuItems> list;

  static{
    list=new ArrayList<>();
    RestaurantList.RestaurantMenuItems restaurantMenuItems1=new RestaurantList.RestaurantMenuItems("PavBhaji",20f);
    RestaurantList.RestaurantMenuItems restaurantMenuItems2=new RestaurantList.RestaurantMenuItems("dosa",30f);
    list.add(restaurantMenuItems1);
    list.add(restaurantMenuItems2);
  };

  public static void main(String[] args) {
    Gson gson = new Gson();
    String json = serializationRest(gson);
    deserializationRest(gson,json);

    json=serializationRestaurantMenuItemsArray(list,gson);
    deserializationRestaurantMenuItemsArray(gson,json);
  }

  private static String serializationRestaurantMenuItemsArray(ArrayList<RestaurantList.RestaurantMenuItems> list, Gson gson) {
    System.out.println(gson.toJson(list));
    return gson.toJson(list);

  }

  private static void deserializationRestaurantMenuItemsArray(Gson gson, String json) {
    Type restaurantMenuItemsType = new TypeToken<ArrayList<RestaurantList.RestaurantMenuItems>>(){}.getType();
     List<RestaurantList.RestaurantMenuItems> restaurantMenuItems = gson.fromJson(json, restaurantMenuItemsType);

  }

  private static void deserializationRest(Gson gson, String json) {
    RestaurantList restaurantList = gson.fromJson(json, RestaurantList.class);
  }

  private static String serializationRest(Gson gson) {
    List<RestaurantList.RestaurantMenuItems> list=new ArrayList<>();
    RestaurantList.RestaurantMenuItems restaurantMenuItems1=new RestaurantList.RestaurantMenuItems("PavBhaji",20f);
    RestaurantList.RestaurantMenuItems restaurantMenuItems2=new RestaurantList.RestaurantMenuItems("dosa",30f);
    list.add(restaurantMenuItems1);
    list.add(restaurantMenuItems2);

    RestaurantList restaurantList = new RestaurantList("Navakar",list);

    return gson.toJson(restaurantList);
  }
}

*/
