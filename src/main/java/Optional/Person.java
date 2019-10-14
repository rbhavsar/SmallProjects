package Optional;

import com.google.common.base.MoreObjects;

/**
 * @author rbhavsar
 * Created on 2/13/19.
 */
public class Person {

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  private String name;

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .add("address", address)
        .toString();
  }

  private Address address;

  public Person(String name,Address address){
    this.name=name;
    this.address=address;
  }
}
