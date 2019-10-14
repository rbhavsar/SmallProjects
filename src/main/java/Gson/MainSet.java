
package Gson;

import java.lang.reflect.Type;
import java.util.HashSet;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */

public class MainSet {

  private static HashSet<String> users;

  static{
    users = new HashSet<>();
    users.add("Christian");
    users.add("Marcus");
    users.add("Norman");
    users.add("Marcus");
  }

  public static void main(String[] args) {
    sample(users);
    String json = "[{\"name\":\"Christian\",\"flowerCount\":1},{\"name\":\"Marcus\",\"flowerCount\":3},{\"name\":\"Norman\",\"flowerCount\":2}]";
    deserializationJson(json);

  }

  private static void deserializationJson(String json) {
    Gson gson=new Gson();
    Type FounderSetType = new TypeToken<HashSet<Founder>>(){}.getType();
    HashSet<String> hashSet= gson.fromJson(json, FounderSetType);
  }

  private static void sample(HashSet<String> users) {
    Gson gson=new Gson();
    String s = gson.toJson(users);
    System.out.println(s);
  }

}

