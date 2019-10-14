
package s3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "AccountId",
    "Master_Status",
    "MasterID",
    "OPID",
    "Revenue_USD",
    "Primary_Team",
    "Created_Date",
    "Name",
    "Order_Type",
    "request_master_id",
    "Lines"
})
public class PreProvionRequest {

    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Master_Status")
    private String masterStatus;
    @JsonProperty("MasterID")
    private String masterID;
    @JsonProperty("OPID")
    private String oPID;
    @JsonProperty("Revenue_USD")
    private String revenueUSD;
    @JsonProperty("Primary_Team")
    private String primaryTeam;
    @JsonProperty("Created_Date")
    private String createdDate;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Order_Type")
    private String orderType;
    @JsonProperty("request_master_id")
    private String requestMasterId;
    @JsonProperty("Lines")
    private List<Line> lines = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AccountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("Master_Status")
    public String getMasterStatus() {
        return masterStatus;
    }

    @JsonProperty("Master_Status")
    public void setMasterStatus(String masterStatus) {
        this.masterStatus = masterStatus;
    }

    @JsonProperty("MasterID")
    public String getMasterID() {
        return masterID;
    }

    @JsonProperty("MasterID")
    public void setMasterID(String masterID) {
        this.masterID = masterID;
    }

    @JsonProperty("OPID")
    public String getOPID() {
        return oPID;
    }

    @JsonProperty("OPID")
    public void setOPID(String oPID) {
        this.oPID = oPID;
    }

    @JsonProperty("Revenue_USD")
    public String getRevenueUSD() {
        return revenueUSD;
    }

    @JsonProperty("Revenue_USD")
    public void setRevenueUSD(String revenueUSD) {
        this.revenueUSD = revenueUSD;
    }

    @JsonProperty("Primary_Team")
    public String getPrimaryTeam() {
        return primaryTeam;
    }

    @JsonProperty("Primary_Team")
    public void setPrimaryTeam(String primaryTeam) {
        this.primaryTeam = primaryTeam;
    }

    @JsonProperty("Created_Date")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("Created_Date")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Order_Type")
    public String getOrderType() {
        return orderType;
    }

    @JsonProperty("Order_Type")
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @JsonProperty("request_master_id")
    public String getRequestMasterId() {
        return requestMasterId;
    }

    @JsonProperty("request_master_id")
    public void setRequestMasterId(String requestMasterId) {
        this.requestMasterId = requestMasterId;
    }

    @JsonProperty("Lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
