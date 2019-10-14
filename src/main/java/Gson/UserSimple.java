
package Gson;

import com.google.gson.annotations.SerializedName;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */

public class UserSimple {

  @SerializedName(value=  "fullname",alternate = "name") //FullName is ok but name is also ok
  private String name;
  private String email;
  private Integer age; // int is not nullable ,if value not specified then it will set 0 , If we use Integer then it will set null.


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean isDeveloper() {
    return isDeveloper;
  }

  public void setDeveloper(boolean developer) {
    isDeveloper = developer;
  }

  private boolean isDeveloper;

  public UserSimple(String name, String email, int age, boolean isDeveloper) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.isDeveloper = isDeveloper;
  }


}

