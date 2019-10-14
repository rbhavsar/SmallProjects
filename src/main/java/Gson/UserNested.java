package Gson;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */
public class UserNested {

  private String name;
  private String email;
  private int age;
  private boolean isDeveloper;
  //Not a primitive type , it is object itself
  private UserAddress userAddress;

  public UserAddress getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(UserAddress userAddress) {
    this.userAddress = userAddress;
  }



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



  public UserNested(String name, String email, int age, boolean isDeveloper,UserAddress userAddress) {
    this.name = name;
    this.email = email;
    this.age = age;
    this.isDeveloper = isDeveloper;
    this.userAddress=userAddress;
  }


}
