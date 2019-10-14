package ComplexJson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author rbhavsar
 * Created on 8/27/18.
 */
public class json1 {

  public static void main(String[] args) throws IOException, ParseException {

        String words = "Ravi Bhavsar ravi bHavsar Harshadbhai kinisha";
        StringTokenizer stringTokenizer = new StringTokenizer(words, " ");
        Map<String,Integer> map = new HashMap<>();
        while(stringTokenizer.hasMoreTokens()){
            String element = stringTokenizer.nextElement().toString().toLowerCase();
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else{
              map.put(element,1);
            }
        }
    System.out.println(map);



//      String filePath1 = "/Users/rbhavsar/SmallProjects/src/main/java/ComplexJson/jsonPayload/payload1.json";
//      String filePath2 = "/Users/rbhavsar/SmallProjects/src/main/java/ComplexJson/jsonPayload/payload2.json";
//    String filePath3 = "/Users/rbhavsar/SmallProjects/src/main/java/ComplexJson/jsonPayload/payload3.json";
//      //parseJson1(filePath1);
//      //parseJson2(filePath2);
//      //parseJson3(filePath2);
//      //parseJson4(filePath2);
//      parseJson5(filePath3);

  }

  private static void parseJson5(String filePath3) throws IOException, ParseException {
    String jsonString = Utils.readData(filePath3);
    JSONArray jsonArray = parseJSONArray(jsonString);
    JSONObject jsonObject = (JSONObject) jsonArray.get(0);
    JSONArray jsonArray1 = (JSONArray) jsonObject.get("columnMetadata");
    JSONObject jsonObject1 = (JSONObject) jsonArray1.get(0);
    System.out.println(jsonObject1);

    for (Object o : jsonArray1) {
      System.out.println(((JSONObject) o).get("name"));
    }

  }

  private static void parseJson4(String filePath2) throws IOException, ParseException {
    String jsonString = Utils.readData(filePath2);
    JSONObject jsonObject = parseJSONObject(jsonString);
    JSONArray jsonArray = (JSONArray) jsonObject.get("results");
    JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
    JSONObject jsonObject2 = (JSONObject) jsonObject1.get("geometry");
    JSONObject jsonObject3 = (JSONObject) jsonObject2.get("viewport");
    JSONObject jsonObject4 = (JSONObject) jsonObject3.get("northeast");
    System.out.println(jsonObject4.get("lat"));
  }

  private static void parseJson3(String filePath2) throws IOException, ParseException {
    String jsonString = Utils.readData(filePath2);
    JSONObject jsonObject = parseJSONObject(jsonString);
    JSONArray jsonArray = (JSONArray) jsonObject.get("results");
    JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
    JSONObject jsonObject2 = (JSONObject) jsonObject1.get("geometry");
    JSONObject jsonObject3 = (JSONObject) jsonObject2.get("location");
    System.out.println(jsonObject3.get("lat"));
  }

  private static void parseJson2(String filePath2) throws IOException, ParseException {
     String jsonString =  Utils.readData(filePath2);
      JSONObject jsonObject = parseJSONObject(jsonString);
      JSONArray jsonArray = (JSONArray) jsonObject.get("results");
      JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);
      JSONArray jsonArray1 = (JSONArray) jsonObject1.get("address_components");
      Object[][] objects = new Object[1][3];

      for (Object o : jsonArray1) {
        Object[] objects1=new Object[3];
        JSONObject jsonObject2 =  (JSONObject)o;
        objects1[0]=jsonObject2.get("name");
        objects1[1]=jsonObject2.get("age");
        objects1[2]=jsonObject2.get("address");
      }

    System.out.println("==============================");

    for (Object o : jsonArray1) {
      JSONObject jsonObject2 =  (JSONObject)o;
      JSONArray jsonArray2 = (JSONArray)jsonObject2.get("types");
      System.out.println(jsonArray2.get(0));

    }
  }


  private static void parseJson1(String filePath) throws IOException, ParseException {
    String jsonString = Utils.readData(filePath);
    JSONObject jsonObject = parseJSONObject(jsonString);
    /*JSONArray jsonArray = (JSONArray)jsonObject.get("headers");
    for (Object o : jsonArray) {
      JSONObject obj = (JSONObject)o;
      if(obj.get("ManuallyEdited").equals(false)){
        System.out.println(obj.get("columnName"));
      }
    }*/
    System.out.println("===================================");
    JSONArray jsonArray1 = (JSONArray) jsonObject.get("rows");
    System.out.println(jsonArray1.get(0));
    for (Object o : jsonArray1) {
     JSONArray jsonArray2 =  (JSONArray)o;
      /*for (Object o1 : jsonArray2) {
        System.out.println(o1);
      }*/
      System.out.println(jsonArray2.get(0));
    }

  }

  private static JSONObject parseJSONObject(String jsonString) throws ParseException {
    return (JSONObject)new JSONParser().parse(jsonString);
  }

  private static JSONArray parseJSONArray(String jsonString) throws ParseException {
    return (JSONArray)new JSONParser().parse(jsonString);
  }
}
