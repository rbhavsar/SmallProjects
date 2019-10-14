package Gson;

/**
 * @author rbhavsar
 * Created on 9/2/18.
 */
public class Restaurant {
  String name;
  RestaurantOwner owner;
  RestaurantStaff cook;
  RestaurantStaff waiter;

  public Restaurant(String name, RestaurantOwner owner, RestaurantStaff cook, RestaurantStaff waiter) {
    this.name = name;
    this.owner = owner;
    this.cook = cook;
    this.waiter = waiter;
  }


  public static class RestaurantOwner {

    String name;
    UserAddress userAddress;

    public RestaurantOwner(String name, UserAddress userAddress) {
      this.name = name;
      this.userAddress = userAddress;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public UserAddress getUserAddress() {
      return userAddress;
    }

    public void setUserAddress(UserAddress userAddress) {
      this.userAddress = userAddress;
    }
  }

  public static class RestaurantStaff {

    int age;
    String name;
    int salary;

    public RestaurantStaff(int age, String name, int salary) {
      this.age = age;
      this.name = name;
      this.salary = salary;
    }

    public int getAge() {
      return age;
    }

    public void setAge(int age) {
      this.age = age;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getSalary() {
      return salary;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }
  }
}
