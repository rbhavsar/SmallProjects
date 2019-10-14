package Util;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "userIds"
})
public class UsersAction {

  @JsonProperty("action")
  private String action;
  @JsonProperty("userIds")
  private List<String> userIds = null;


  @JsonProperty("action")
  public String getAction() {
    return action;
  }

  @JsonProperty("action")
  public void setAction(String action) {
    this.action = action;
  }

  @JsonProperty("userIds")
  public List<String> getUserIds() {
    return userIds;
  }

  @JsonProperty("userIds")
  public void setUserIds(List<String> userIds) {
    this.userIds = userIds;
  }


}