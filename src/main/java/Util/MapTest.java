package Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Util.com.PreProvision;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;

/**
 * @author rbhavsar
 * Created on 3/29/19.
 */
public class MapTest {

  public static void main(String[] args) throws ParseException, IOException {

    String jsonString = "{" +
        "  \"AccountId\": \"1~100060609\"," +
        "  \"Master_Status\": \"Pending\"," +
        "  \"Lines\": [" +
        "    {" +
        "      \"RequestID\": \"250696-001\"," +
        "      \"SKU_CD\": \"BBI-S-ADD-ALWYSON\"" +
        "    }," +
        "    {" +
        "      \"RequestID\": \"250696-001\"," +
        "      \"SKU_CD\": \"BBI-S-ADD-CONDP\"" +
        "    }" +
        "  ]" +
        "}";


    JSONParser parser = new JSONParser();
    JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
    System.out.println(jsonObject.get("AccountId"));
    JSONArray jsonArray = (JSONArray) jsonObject.get("Lines");
    Iterator iterator = jsonArray.iterator();
    while(iterator.hasNext()){
      Iterator<Map.Entry> itr1 = ((Map) iterator.next()).entrySet().iterator();
      while(itr1.hasNext()){
        Map.Entry pair = itr1.next();
        System.out.println("key : "+pair.getKey()+", value: "+pair.getValue());
      }
    }


    jsonString = "{" +
        "  \"AccountId\":\"Test123\"," +
        "  \"username\":\"rbhavsar@birst.com\"" +
        "}";

    ObjectMapper mapper = new ObjectMapper();
    PreProvision preProvision = mapper.readValue(jsonString,PreProvision.class);

    System.out.println("preProvision: "+preProvision.toString());
    System.out.println("accountId: "+preProvision.getAccountId());


    String word = "Ravi";
    //System.out.println(Character.toUpperCase(word.charAt(0)));
    //CamelCaseUtils.toCamelCase("RaviBhavsar");
    System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "THIS_IS_AN_EXAMPLE_STRING"));



    JSONObject jo = new JSONObject();

    // putting data to JSONObject
    jo.put("AccountId", "1~2130");
    jo.put("username","rbhavsar@birst.com");


    JSONArray ja = new JSONArray();
    Map m = new LinkedHashMap(2);
    m.put("SKU_CD","BB01");
    m.put("COOKIES","x0x0x0");
    ja.add(m);

    m = new LinkedHashMap(2);
    m.put("SKU_CD","AA01");
    m.put("COOKIES","y0y0y0");
    ja.add(m);

    jo.put("lines",ja);


    List<String> list = new ArrayList<>();
    list.add("accountId");
    list.add("sku_cd");

    MapTest obj = new MapTest();
   //obj.getIgnoreCase(jo, "accountId");
    transformRequestedObject(jo);
    System.out.println(transformRequestedObject(jo).toJSONString());


    Map<String,String> users = new HashMap<>();
    users.put("12ra34","12ra34_val");
    users.put("12VI34","12vi34_val");

//    if(users.containsKey("12ra34")){
//      System.out.println("found");
//    }

    System.out.println(Arrays.toString(users.entrySet().toArray()));


//    Set<String> users = new HashSet<>();
//    users.add("ravi");
//    users.add("RAVI");
//
//    if(users.contains("RavI")){
//
//    }

//      List<String> users = new ArrayList<>();
//      List<String> usersToLowerCase = new ArrayList<>();
//      users.add("ravi");
//      users.add("Ravi");
//
//      usersToLowerCase.replaceAll(String::toUpperCase);
//
//    for (String s : usersToLowerCase) {
//      System.out.println(s);
//    }
      

  }

  private static JSONObject transformRequestedObject(JSONObject jobj) {
    JSONObject newObject = new JSONObject();
    Iterator<String> iter = jobj.keySet().iterator();
    while (iter.hasNext()) {
      String key = iter.next();
      String value = (String) jobj.get(key);
      newObject.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, key), value);
    }
    return newObject;
  }

  public JSONObject getIgnoreCase(JSONObject jobj, String key) {

    JSONObject newObject = new JSONObject();
    Iterator<String> iter = jobj.keySet().iterator();
    while (iter.hasNext()) {
      String key1 = iter.next();
      String value = (String) jobj.get(key1);
      if (key1.equalsIgnoreCase(key)) {
        newObject.put(key,value);
      }else {
        newObject.put(key1, value);
      }
    }

    return newObject;

  }


}
