package Employee;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonUtil {

    private static ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
    }

    public static String convertJavaObjectToJson(Object object) {
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(object);
            //System.out.println("jasonString :"+jsonString);
        } catch (IOException e) {
            System.out.println("Exception occur while Converting Java Object to json :" + e.getMessage());
            e.printStackTrace();
        }
        return jsonString;
    }

    public static <T> T convertJsonStringToJava(String jsonString, Class<T> cls) {
        T result = null;
        try {
            result = mapper.readValue(jsonString, cls);
        } catch (IOException e) {
            System.out.println("Exception occur while Converting Json String to Java Object " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


    public static List<Employee> convertJsonArrayToListObject(String jsonArray, TypeReference<List<Employee>> cls) {
        List<Employee> result = null;
        try {
            result = mapper.readValue(jsonArray, cls);
        } catch (Exception e) {
            System.out.println("Exception occur while convert Json String to List Object " + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String,Object> convertJsonStringToMapObject(String jsonString, TypeReference<Map<String,Object>> cls)
    {
        Map<String,Object> result = null;
        try {
            result = mapper.readValue(jsonString, cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getNodeValue(String jsonString, String node) {
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode.get(node).asText();
    }
}