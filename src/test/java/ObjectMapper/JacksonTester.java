package ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * @author rbhavsar
 * Created on 4/28/18.
 */

/*
Simple Data Binding
Simple data binding refers to mapping of JSON to JAVA Core data types. Following table illustrates the relationship between JSON types vs Java Types.

https://www.tutorialspoint.com/jackson/jackson_data_binding.htm

Sr. No.	JSON          Type	Java Type
1	      object =====>	LinkedHashMap<String,Object>
2	      array	======> ArrayList<Object>
3	      string =====>	String
4	      complete number ==>	Integer, Long or BigInteger
5	      fractional number ==>	Double / BigDecimal
6	    true | false ==>	Boolean
7	      null ==>	null
 */

public class JacksonTester {

  public static void main(String[] args) throws IOException {
    JacksonTester tester = new JacksonTester();

    ObjectMapper mapper = new ObjectMapper();
    Map<String,Object> studentMap = new HashMap<String,Object>();
    Integer[] marks={1,2,3};

    Student student = new Student();
    student.setAge(10);
    student.setName("Mahesh");
    studentMap.put("verified", Boolean.FALSE);
    studentMap.put("name", "Mahesh Kumar");

    studentMap.put("student",student);

    studentMap.put("marks",marks);


    studentMap = mapper.readValue(new File("student.json"), Map.class);


    System.out.println(studentMap.get("student"));
    System.out.println(studentMap.get("name"));
    System.out.println(studentMap.get("verified"));
    System.out.println(studentMap.get("marks"));

    try {
      mapper.writeValue(new File("student.json"), studentMap);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  static class Student {
    private String name;
    private int age;
    public Student(){}
    public String getName() {
      return name;
    }
    public void setName(String name) {
      this.name = name;
    }
    public int getAge() {
      return age;
    }
    public void setAge(int age) {
      this.age = age;
    }
    public String toString(){
      return "Student [ name: "+name+", age: "+ age+ " ]";
    }
  }

}
