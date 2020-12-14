package com.example.createlocation.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateLocationModel {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("streetName")
    @Expose
    private String streetName;
    @SerializedName("addressDescription")
    @Expose
    private String addressDescription;
    @SerializedName("buildingNo")
    @Expose
    private String buildingNo;
    @SerializedName("neighborhood")
    @Expose
    private String neighborhood;
    @SerializedName("postalCode")
    @Expose
    private int postalCode;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("saftyOfficeId")
    @Expose
    private Integer saftyOfficeId;
    @SerializedName("locationCategoryId")
    @Expose
    private Integer locationCategoryId;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("constructionLicenseNo")
    @Expose
    private String constructionLicenseNo;
    @SerializedName("tourismAuthorityLicenseNo")
    @Expose
    private String tourismAuthorityLicenseNo;
    @SerializedName("workingHours")
    @Expose
    private String workingHours;
    @SerializedName("guardName")
    @Expose
    private String guardName;
    @SerializedName("guardMobile")
    @Expose
    private String guardMobile;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("recordStatus")
    @Expose
    private Integer recordStatus;
    @SerializedName("lastModifiedDate")
    @Expose
    private String lastModifiedDate;
    @SerializedName("closureOrRemovalReasons")
    @Expose
    private String closureOrRemovalReasons;
    @SerializedName("safetyOfficerName")
    @Expose
    private String safetyOfficerName;
    @SerializedName("safetyOfficerMobile")
    @Expose
    private String safetyOfficerMobile;
    @SerializedName("buildingOperatorName")
    @Expose
    private String buildingOperatorName;
    @SerializedName("buildingOwnerName")
    @Expose
    private String buildingOwnerName;
    @SerializedName("civilDefenseLicenseNo")
    @Expose
    private String civilDefenseLicenseNo;
    @SerializedName("liftsFacility")
    @Expose
    private String liftsFacility;
    @SerializedName("saftyFacility")
    @Expose
    private String saftyFacility;
    @SerializedName("contractType")
    @Expose
    private Integer contractType;
    @SerializedName("hajHousingLicense")
    @Expose
    private String hajHousingLicense;
    @SerializedName("electricitySubscription")
    @Expose
    private String electricitySubscription;
    @SerializedName("facilityId")
    @Expose
    private Integer facilityId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getSaftyOfficeId() {
        return saftyOfficeId;
    }

    public void setSaftyOfficeId(Integer saftyOfficeId) {
        this.saftyOfficeId = saftyOfficeId;
    }

    public Integer getLocationCategoryId() {
        return locationCategoryId;
    }

    public void setLocationCategoryId(Integer locationCategoryId) {
        this.locationCategoryId = locationCategoryId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getConstructionLicenseNo() {
        return constructionLicenseNo;
    }

    public void setConstructionLicenseNo(String constructionLicenseNo) {
        this.constructionLicenseNo = constructionLicenseNo;
    }

    public String getTourismAuthorityLicenseNo() {
        return tourismAuthorityLicenseNo;
    }

    public void setTourismAuthorityLicenseNo(String tourismAuthorityLicenseNo) {
        this.tourismAuthorityLicenseNo = tourismAuthorityLicenseNo;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public String getGuardName() {
        return guardName;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public String getGuardMobile() {
        return guardMobile;
    }

    public void setGuardMobile(String guardMobile) {
        this.guardMobile = guardMobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getClosureOrRemovalReasons() {
        return closureOrRemovalReasons;
    }

    public void setClosureOrRemovalReasons(String closureOrRemovalReasons) {
        this.closureOrRemovalReasons = closureOrRemovalReasons;
    }

    public String getSafetyOfficerName() {
        return safetyOfficerName;
    }

    public void setSafetyOfficerName(String safetyOfficerName) {
        this.safetyOfficerName = safetyOfficerName;
    }

    public String getSafetyOfficerMobile() {
        return safetyOfficerMobile;
    }

    public void setSafetyOfficerMobile(String safetyOfficerMobile) {
        this.safetyOfficerMobile = safetyOfficerMobile;
    }

    public String getBuildingOperatorName() {
        return buildingOperatorName;
    }

    public void setBuildingOperatorName(String buildingOperatorName) {
        this.buildingOperatorName = buildingOperatorName;
    }

    public String getBuildingOwnerName() {
        return buildingOwnerName;
    }

    public void setBuildingOwnerName(String buildingOwnerName) {
        this.buildingOwnerName = buildingOwnerName;
    }

    public String getCivilDefenseLicenseNo() {
        return civilDefenseLicenseNo;
    }

    public void setCivilDefenseLicenseNo(String civilDefenseLicenseNo) {
        this.civilDefenseLicenseNo = civilDefenseLicenseNo;
    }

    public String getLiftsFacility() {
        return liftsFacility;
    }

    public void setLiftsFacility(String liftsFacility) {
        this.liftsFacility = liftsFacility;
    }

    public String getSaftyFacility() {
        return saftyFacility;
    }

    public void setSaftyFacility(String saftyFacility) {
        this.saftyFacility = saftyFacility;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public String getHajHousingLicense() {
        return hajHousingLicense;
    }

    public void setHajHousingLicense(String hajHousingLicense) {
        this.hajHousingLicense = hajHousingLicense;
    }

    public String getElectricitySubscription() {
        return electricitySubscription;
    }

    public void setElectricitySubscription(String electricitySubscription) {
        this.electricitySubscription = electricitySubscription;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

}
