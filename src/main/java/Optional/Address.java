package Optional;

import com.google.common.base.MoreObjects;

/**
 * @author rbhavsar
 * Created on 2/13/19.
 */
public class Address {

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("city", city)
        .add("country", country)
        .toString();
  }

  private String city;

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  private String country;

  public Address(String city,String country){
    this.city=city;
    this.country=country;
  }
}
