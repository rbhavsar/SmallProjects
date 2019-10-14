package Jackson.Student;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rbhavsar
 * Created on 9/21/18.
 */
public class JacksonTester {

  public static void main(String[] args) {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
    Student student = new Student("Ravi",30);
    try {
      String json = objectMapper.writeValueAsString(student);
      student = objectMapper.readValue(jsonString, Student.class);
      System.out.println(student);
      jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
      System.out.println(jsonString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
