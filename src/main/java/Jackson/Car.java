package Jackson;

import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * @author rbhavsar
 * Created on 9/3/18.
 */
public class Car {

  @JsonSerialize
  private String color;
  @JsonSerialize
  private String type;

  public Car(String color, String type) {
    this.color = color;
    this.type = type;
  }



  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


}
