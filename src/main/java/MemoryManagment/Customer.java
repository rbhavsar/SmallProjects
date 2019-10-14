package MemoryManagment;

import com.google.common.base.MoreObjects;

/**
 * @author rbhavsar
 * Created on 4/6/19.
 */
public class Customer {
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", name)
        .toString();
  }

  private String name;
  public Customer(String name) {
    this.name=name;
  }
}
