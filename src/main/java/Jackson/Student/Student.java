package Jackson.Student;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * @author rbhavsar
 * Created on 9/21/18.
 */
@JsonPropertyOrder({"age","name"})
@JsonIgnoreProperties({ "id" })
public class Student {

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

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
