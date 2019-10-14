
package Gson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author rbhavsar
 * Created on 9/2/18.
 */

public class Main {

  //https://futurestud.io/tutorials/gson-mapping-of-nested-objects

  public static void main(String[] args) {

    Gson gson = new Gson();
    String json = serializeUserSimple(gson);
    deserializeUserSimple(gson,json);

    String json1 = serializeUserNested(gson);
    deserializeUserNested(gson,json1);

    String json2  =serializeRestaurant(gson);

    deserializeRestaurant(gson,json2);
  }

  private static void deserializeRestaurant(Gson gson,String json2) {
      Restaurant restaurant= gson.fromJson(json2,Restaurant.class);
  }

  private static String serializeRestaurant(Gson gson) {
    UserAddress userAddress = new UserAddress("Decoto Rd","42A","uninonCity","USA");
    Restaurant.RestaurantStaff restaurantStaff=new Restaurant.RestaurantStaff(32,"test",213);
    Restaurant restaurant = new Restaurant("Taj",new Restaurant.RestaurantOwner("Ravi",userAddress),restaurantStaff,restaurantStaff);
    return gson.toJson(restaurant);
  }

  private static void deserializeUserNested(Gson gson, String json1) {
    UserNested userNested = gson.fromJson(json1,UserNested.class);
    System.out.println(userNested.getAge()+":"+userNested.getUserAddress());
  }

  private static String serializeUserNested(Gson gson) {
    UserAddress userAddress = new UserAddress("Decoto Rd","42A","uninonCity","USA");
    UserNested userNested = new UserNested("Ravi","rbhavsar@birst.com",31,true,userAddress);
    return gson.toJson(userNested);
  }

  private static String serializeUserSimple(Gson gson) {
    UserSimple userSimple=new UserSimple("Ravi","rbhavsar@birst.com",31,true);
    String json = gson.toJson(userSimple);
    return json;

  }


  private static void deserializeUserSimple(Gson gson,String json) {
    json = "{\"name\":\"Ravi\",\"email\":\"rbhavsar@birst.com\",\"isDeveloper\":true}";
    gson = new GsonBuilder().serializeNulls().create();
    UserSimple userSimple = gson.fromJson(json, UserSimple.class);
    System.out.println(":"+userSimple.getEmail()+":"+userSimple.getName());

  }
}

