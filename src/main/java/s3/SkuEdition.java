package s3;

/**
 * @author rbhavsar
 * Created on 9/27/19.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "sku"
})
public class SkuEdition {

  @JsonProperty("sku")
  private String sku;


  @JsonProperty("sku")
  public String getSku() {
    return sku;
  }

  @JsonProperty("sku")
  public void setSku(String sku) {
    this.sku = sku;
  }

}