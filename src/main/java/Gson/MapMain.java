
package Gson;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * @author rbhavsar
 * Created on 9/2/18.
 */

public class MapMain {

  public static void main(String[] args) {
    sample();
    String json = "{\"1$\":{\"amount\":1,\"currency\":\"Dollar\"},\"2$\":{\"amount\":2,\"currency\":\"Dollar\"},\"3€\":{\"amount\":3,\"currency\":\"Euro\"}}";
    deserializationMap(json);
  }

  private static void deserializationMap(String json) {
    Gson gson=new Gson();
    Type amountCurrencyType = new TypeToken<HashMap<String,AccountCurrencyDetail>>(){}.getType();
    HashMap<String,AccountCurrencyDetail> hashMap  = gson.fromJson(json, amountCurrencyType);

  }

  private static void sample() {
    HashMap<String, List<String>> employees = new HashMap<>();
    employees.put("A", Arrays.asList("Anal","Amitabh","Ajay"));
    employees.put("B",Arrays.asList("Babita","Boby","Bansari"));
    employees.put("C",Arrays.asList("Chirag","Chaman","Cipla"));

    Serialize(employees);
  }

  private static void Serialize(HashMap<String,List<String>> employees) {
    Gson gson = new Gson();
    String s = gson.toJson(employees);
    System.out.println(s);

  }

}

