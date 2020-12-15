package com.example.createlocation.pojo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "create_location")
public class CreateLocationDB {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String streetName;
    private String addressDescription;
    private String buildingNo;
    private String neighborhood;
    private Integer postalCode;
    private String longitude;
    private String latitude;
    private Integer saftyOfficeId;
    private Integer locationCategoryId;
    private Integer type;
    private String constructionLicenseNo;
    private String tourismAuthorityLicenseNo;
    private String workingHours;
    private String guardName;
    private String guardMobile;
    private Integer status;
    private Integer recordStatus;
    private String lastModifiedDate;
    private String closureOrRemovalReasons;
    private String safetyOfficerName;
    private String safetyOfficerMobile;
    private String buildingOperatorName;
    private String buildingOwnerName;
    private String civilDefenseLicenseNo;
    private String liftsFacility;
    private String saftyFacility;
    private Integer contractType;
    private String hajHousingLicense;
    private String electricitySubscription;
    private Integer facilityId;

    public CreateLocationDB() {
    }

    public CreateLocationDB(int id, String name, String streetName, String addressDescription, String buildingNo, String neighborhood, Integer postalCode, String longitude, String latitude, Integer saftyOfficeId, Integer locationCategoryId, Integer type, String constructionLicenseNo, String tourismAuthorityLicenseNo, String workingHours, String guardName, String guardMobile, Integer status, Integer recordStatus, String lastModifiedDate, String closureOrRemovalReasons, String safetyOfficerName, String safetyOfficerMobile, String buildingOperatorName, String buildingOwnerName, String civilDefenseLicenseNo, String liftsFacility, String saftyFacility, Integer contractType, String hajHousingLicense, String electricitySubscription, Integer facilityId) {
        this.id = id;
        this.name = name;
        this.streetName = streetName;
        this.addressDescription = addressDescription;
        this.buildingNo = buildingNo;
        this.neighborhood = neighborhood;
        this.postalCode = postalCode;
        this.longitude = longitude;
        this.latitude = latitude;
        this.saftyOfficeId = saftyOfficeId;
        this.locationCategoryId = locationCategoryId;
        this.type = type;
        this.constructionLicenseNo = constructionLicenseNo;
        this.tourismAuthorityLicenseNo = tourismAuthorityLicenseNo;
        this.workingHours = workingHours;
        this.guardName = guardName;
        this.guardMobile = guardMobile;
        this.status = status;
        this.recordStatus = recordStatus;
        this.lastModifiedDate = lastModifiedDate;
        this.closureOrRemovalReasons = closureOrRemovalReasons;
        this.safetyOfficerName = safetyOfficerName;
        this.safetyOfficerMobile = safetyOfficerMobile;
        this.buildingOperatorName = buildingOperatorName;
        this.buildingOwnerName = buildingOwnerName;
        this.civilDefenseLicenseNo = civilDefenseLicenseNo;
        this.liftsFacility = liftsFacility;
        this.saftyFacility = saftyFacility;
        this.contractType = contractType;
        this.hajHousingLicense = hajHousingLicense;
        this.electricitySubscription = electricitySubscription;
        this.facilityId = facilityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setSaftyOfficeId(Integer saftyOfficeId) {
        this.saftyOfficeId = saftyOfficeId;
    }

    public void setLocationCategoryId(Integer locationCategoryId) {
        this.locationCategoryId = locationCategoryId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setConstructionLicenseNo(String constructionLicenseNo) {
        this.constructionLicenseNo = constructionLicenseNo;
    }

    public void setTourismAuthorityLicenseNo(String tourismAuthorityLicenseNo) {
        this.tourismAuthorityLicenseNo = tourismAuthorityLicenseNo;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public void setGuardName(String guardName) {
        this.guardName = guardName;
    }

    public void setGuardMobile(String guardMobile) {
        this.guardMobile = guardMobile;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setClosureOrRemovalReasons(String closureOrRemovalReasons) {
        this.closureOrRemovalReasons = closureOrRemovalReasons;
    }

    public void setSafetyOfficerName(String safetyOfficerName) {
        this.safetyOfficerName = safetyOfficerName;
    }

    public void setSafetyOfficerMobile(String safetyOfficerMobile) {
        this.safetyOfficerMobile = safetyOfficerMobile;
    }

    public void setBuildingOperatorName(String buildingOperatorName) {
        this.buildingOperatorName = buildingOperatorName;
    }

    public void setBuildingOwnerName(String buildingOwnerName) {
        this.buildingOwnerName = buildingOwnerName;
    }

    public void setCivilDefenseLicenseNo(String civilDefenseLicenseNo) {
        this.civilDefenseLicenseNo = civilDefenseLicenseNo;
    }

    public void setLiftsFacility(String liftsFacility) {
        this.liftsFacility = liftsFacility;
    }

    public void setSaftyFacility(String saftyFacility) {
        this.saftyFacility = saftyFacility;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public void setHajHousingLicense(String hajHousingLicense) {
        this.hajHousingLicense = hajHousingLicense;
    }

    public void setElectricitySubscription(String electricitySubscription) {
        this.electricitySubscription = electricitySubscription;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public Integer getSaftyOfficeId() {
        return saftyOfficeId;
    }

    public Integer getLocationCategoryId() {
        return locationCategoryId;
    }

    public Integer getType() {
        return type;
    }

    public String getConstructionLicenseNo() {
        return constructionLicenseNo;
    }

    public String getTourismAuthorityLicenseNo() {
        return tourismAuthorityLicenseNo;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public String getGuardName() {
        return guardName;
    }

    public String getGuardMobile() {
        return guardMobile;
    }

    public Integer getStatus() {
        return status;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public String getClosureOrRemovalReasons() {
        return closureOrRemovalReasons;
    }

    public String getSafetyOfficerName() {
        return safetyOfficerName;
    }

    public String getSafetyOfficerMobile() {
        return safetyOfficerMobile;
    }

    public String getBuildingOperatorName() {
        return buildingOperatorName;
    }

    public String getBuildingOwnerName() {
        return buildingOwnerName;
    }

    public String getCivilDefenseLicenseNo() {
        return civilDefenseLicenseNo;
    }

    public String getLiftsFacility() {
        return liftsFacility;
    }

    public String getSaftyFacility() {
        return saftyFacility;
    }

    public Integer getContractType() {
        return contractType;
    }

    public String getHajHousingLicense() {
        return hajHousingLicense;
    }

    public String getElectricitySubscription() {
        return electricitySubscription;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

}
