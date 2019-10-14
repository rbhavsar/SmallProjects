
package s3;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RequestID",
    "Provision_Team",
    "Request_Status",
    "Provision_Date",
    "Start_Date",
    "Notes",
    "Request_Detail_Id",
    "SKU_Description",
    "Parent_SKU_CD",
    "SKU_CD",
    "SKU_Product_Line_Id",
    "User_Count",
    "License_Option",
    "Process_Type",
    "Site_Location",
    "request_expected_provisioned_dt",
    "request_provisioned_dt",
    "maintenance_start_dt",
    "maintenance_end_dt",
    "list_price",
    "selling_price_USD",
    "discount",
    "created_by",
    "modified_by",
    "request_modified_by",
    "created_dt",
    "modified_dt"
})
public class Line {

    @JsonProperty("RequestID")
    private String requestID;
    @JsonProperty("Provision_Team")
    private String provisionTeam;
    @JsonProperty("Request_Status")
    private String requestStatus;
    @JsonProperty("Provision_Date")
    private String provisionDate;
    @JsonProperty("Start_Date")
    private String startDate;
    @JsonProperty("Notes")
    private String notes;
    @JsonProperty("Request_Detail_Id")
    private String requestDetailId;
    @JsonProperty("SKU_Description")
    private String sKUDescription;
    @JsonProperty("Parent_SKU_CD")
    private String parentSKUCD;
    @JsonProperty("SKU_CD")
    private String sKUCD;
    @JsonProperty("SKU_Product_Line_Id")
    private String sKUProductLineId;
    @JsonProperty("User_Count")
    private String userCount;
    @JsonProperty("License_Option")
    private String licenseOption;
    @JsonProperty("Process_Type")
    private String processType;
    @JsonProperty("Site_Location")
    private String siteLocation;
    @JsonProperty("request_expected_provisioned_dt")
    private String requestExpectedProvisionedDt;
    @JsonProperty("request_provisioned_dt")
    private String requestProvisionedDt;
    @JsonProperty("maintenance_start_dt")
    private String maintenanceStartDt;
    @JsonProperty("maintenance_end_dt")
    private String maintenanceEndDt;
    @JsonProperty("list_price")
    private String listPrice;
    @JsonProperty("selling_price_USD")
    private String sellingPriceUSD;
    @JsonProperty("discount")
    private String discount;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty("modified_by")
    private String modifiedBy;
    @JsonProperty("request_modified_by")
    private String requestModifiedBy;
    @JsonProperty("created_dt")
    private String createdDt;
    @JsonProperty("modified_dt")
    private String modifiedDt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("RequestID")
    public String getRequestID() {
        return requestID;
    }

    @JsonProperty("RequestID")
    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    @JsonProperty("Provision_Team")
    public String getProvisionTeam() {
        return provisionTeam;
    }

    @JsonProperty("Provision_Team")
    public void setProvisionTeam(String provisionTeam) {
        this.provisionTeam = provisionTeam;
    }

    @JsonProperty("Request_Status")
    public String getRequestStatus() {
        return requestStatus;
    }

    @JsonProperty("Request_Status")
    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    @JsonProperty("Provision_Date")
    public String getProvisionDate() {
        return provisionDate;
    }

    @JsonProperty("Provision_Date")
    public void setProvisionDate(String provisionDate) {
        this.provisionDate = provisionDate;
    }

    @JsonProperty("Start_Date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("Start_Date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("Notes")
    public String getNotes() {
        return notes;
    }

    @JsonProperty("Notes")
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @JsonProperty("Request_Detail_Id")
    public String getRequestDetailId() {
        return requestDetailId;
    }

    @JsonProperty("Request_Detail_Id")
    public void setRequestDetailId(String requestDetailId) {
        this.requestDetailId = requestDetailId;
    }

    @JsonProperty("SKU_Description")
    public String getSKUDescription() {
        return sKUDescription;
    }

    @JsonProperty("SKU_Description")
    public void setSKUDescription(String sKUDescription) {
        this.sKUDescription = sKUDescription;
    }

    @JsonProperty("Parent_SKU_CD")
    public String getParentSKUCD() {
        return parentSKUCD;
    }

    @JsonProperty("Parent_SKU_CD")
    public void setParentSKUCD(String parentSKUCD) {
        this.parentSKUCD = parentSKUCD;
    }

    @JsonProperty("SKU_CD")
    public String getSKUCD() {
        return sKUCD;
    }

    @JsonProperty("SKU_CD")
    public void setSKUCD(String sKUCD) {
        this.sKUCD = sKUCD;
    }

    @JsonProperty("SKU_Product_Line_Id")
    public String getSKUProductLineId() {
        return sKUProductLineId;
    }

    @JsonProperty("SKU_Product_Line_Id")
    public void setSKUProductLineId(String sKUProductLineId) {
        this.sKUProductLineId = sKUProductLineId;
    }

    @JsonProperty("User_Count")
    public String getUserCount() {
        return userCount;
    }

    @JsonProperty("User_Count")
    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    @JsonProperty("License_Option")
    public String getLicenseOption() {
        return licenseOption;
    }

    @JsonProperty("License_Option")
    public void setLicenseOption(String licenseOption) {
        this.licenseOption = licenseOption;
    }

    @JsonProperty("Process_Type")
    public String getProcessType() {
        return processType;
    }

    @JsonProperty("Process_Type")
    public void setProcessType(String processType) {
        this.processType = processType;
    }

    @JsonProperty("Site_Location")
    public String getSiteLocation() {
        return siteLocation;
    }

    @JsonProperty("Site_Location")
    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    @JsonProperty("request_expected_provisioned_dt")
    public String getRequestExpectedProvisionedDt() {
        return requestExpectedProvisionedDt;
    }

    @JsonProperty("request_expected_provisioned_dt")
    public void setRequestExpectedProvisionedDt(String requestExpectedProvisionedDt) {
        this.requestExpectedProvisionedDt = requestExpectedProvisionedDt;
    }

    @JsonProperty("request_provisioned_dt")
    public String getRequestProvisionedDt() {
        return requestProvisionedDt;
    }

    @JsonProperty("request_provisioned_dt")
    public void setRequestProvisionedDt(String requestProvisionedDt) {
        this.requestProvisionedDt = requestProvisionedDt;
    }

    @JsonProperty("maintenance_start_dt")
    public String getMaintenanceStartDt() {
        return maintenanceStartDt;
    }

    @JsonProperty("maintenance_start_dt")
    public void setMaintenanceStartDt(String maintenanceStartDt) {
        this.maintenanceStartDt = maintenanceStartDt;
    }

    @JsonProperty("maintenance_end_dt")
    public String getMaintenanceEndDt() {
        return maintenanceEndDt;
    }

    @JsonProperty("maintenance_end_dt")
    public void setMaintenanceEndDt(String maintenanceEndDt) {
        this.maintenanceEndDt = maintenanceEndDt;
    }

    @JsonProperty("list_price")
    public String getListPrice() {
        return listPrice;
    }

    @JsonProperty("list_price")
    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("selling_price_USD")
    public String getSellingPriceUSD() {
        return sellingPriceUSD;
    }

    @JsonProperty("selling_price_USD")
    public void setSellingPriceUSD(String sellingPriceUSD) {
        this.sellingPriceUSD = sellingPriceUSD;
    }

    @JsonProperty("discount")
    public String getDiscount() {
        return discount;
    }

    @JsonProperty("discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @JsonProperty("created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("created_by")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("modified_by")
    public String getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modified_by")
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("request_modified_by")
    public String getRequestModifiedBy() {
        return requestModifiedBy;
    }

    @JsonProperty("request_modified_by")
    public void setRequestModifiedBy(String requestModifiedBy) {
        this.requestModifiedBy = requestModifiedBy;
    }

    @JsonProperty("created_dt")
    public String getCreatedDt() {
        return createdDt;
    }

    @JsonProperty("created_dt")
    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }

    @JsonProperty("modified_dt")
    public String getModifiedDt() {
        return modifiedDt;
    }

    @JsonProperty("modified_dt")
    public void setModifiedDt(String modifiedDt) {
        this.modifiedDt = modifiedDt;
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
