package JsonText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;




/**
 * @author <a href='mailto:pauld@birst.com>Patrick Auld</a>
 * Created on 4/25/18.
 */
public class Json {

  public static void main(String[] args){

    //jsonEncode();
    //jsonEncodeUsingMap();
    //jsonEncodeUsingArray();
    //jsonEncodeArrayUsingList();
    //parse1("{\"name\":\"sonoo\",\"salary\":600000.0,\"age\":27}");
    //parse2("{\"employee\": { \"name\":\"sonoo\", \"salary\":56000, \"married\":true}}");
    //parse3("{\"employees\":[{\"name\":\"Shyam\", \"email\":\"shyamjaiswal@gmail.com\"},{\"name\":\"Bob\", \"email\":\"bob32@gmail.com\"},{\"name\":\"Jai\", \"email\":\"jai87@gmail.com\"}]}");

    parse4("{\"menu\": {  \n" +
        "  \"id\": \"file\",  \n" +
        "  \"value\": \"File\",  \n" +
        "  \"popup\": {  \n" +
        "    \"menuitem\": [  \n" +
        "      {\"value\": \"New\", \"onclick\": \"CreateDoc()\"},  \n" +
        "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},  \n" +
        "      {\"value\": \"Save\", \"onclick\": \"SaveDoc()\"}  \n" +
        "    ]  \n" +
        "  }  \n" +
        "}}  ");
  }

  private static void parse4(String s) {

    Object obj = JSONValue.parse(s);
    JSONObject jsonObject = (JSONObject)obj;
    System.out.println(jsonObject.get("menu"));
    JSONObject obj1 = (JSONObject)jsonObject.get("menu");
    System.out.println(obj1.get("id"));
    System.out.println(obj1.get("value"));
    System.out.println(obj1.get("popup"));
    JSONObject jsonObj1=(JSONObject)obj1.get("popup");
    System.out.println(jsonObj1.get("menuitem"));

    JSONArray jsonArray = (JSONArray)jsonObj1.get("menuitem");
    for (Object o : jsonArray) {
      JSONObject ob = (JSONObject) o;
      System.out.println(ob.get("value"));
      System.out.println(ob.get("onclick"));
    }


  }

  private static void parse3(String s) {
    Object obj=JSONValue.parse(s);
    JSONObject jsonObject=(JSONObject)obj;
    System.out.println(jsonObject.get("employees"));
    JSONArray jsonArray = (JSONArray) jsonObject.get("employees");
    int i=1;
    for (Object o : jsonArray) {
      JSONObject jObj = (JSONObject)o;
      System.out.print(i+":");
      System.out.print(jObj.get("name")+":");
      System.out.print(jObj.get("email"));
      System.out.println();
      i++;
    }
  }

  private static void parse2(String s) {

    Object obj = JSONValue.parse(s);
    JSONObject jsonObj = (JSONObject)obj;
    System.out.println(jsonObj.get("employee"));
    Object emp = jsonObj.get("employee");
    JSONObject obj1 = (JSONObject) (emp);
    System.out.println(obj1.get("name"));
  }

  private static void parse1(String s) {
    Object obj = JSONValue.parse(s);
    JSONObject jsonObj = (JSONObject) obj;
    System.out.println((String)jsonObj.get("name"));
    System.out.println((Double) jsonObj.get("salary"));
    System.out.println((Long) jsonObj.get("age"));
  }

  private static void jsonEncodeArrayUsingList() {
    List arr = new ArrayList();
    arr.add("Sonoo");
    arr.add(new Integer(27));
    arr.add(new Double(2000));
    String s = JSONValue.toJSONString(arr);
    System.out.println(s);
  }

  private static void jsonEncodeUsingArray() {
    JSONArray array=new JSONArray();
    array.add("ravi");
    array.add(new Integer(30));
    array.add(new Double(6000));

    System.out.println(array);
  }

  private static void jsonEncodeUsingMap() {
   Map obj=new HashMap();
   obj.put("name","ravi");
   obj.put("age",new Integer(30));
   obj.put("salary",new Integer(6000));

    String s = JSONValue.toJSONString(obj);
    System.out.println(s);
  }

  private static void jsonEncode(){

    JSONObject obj=new JSONObject();
    obj.put("name","ravi");
    obj.put("age",new Integer(30));
    obj.put("salary",new Double(60000));

    System.out.println(obj);
  }
}
