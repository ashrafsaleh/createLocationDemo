package com.example.createlocation.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetAllDropDown {
    @SerializedName("contractType")
    @Expose
    private List<String> contractType = null;
    @SerializedName("locationCategories")
    @Expose
    private List<LocationCategories> locationCategories = null;
    @SerializedName("locationStatus")
    @Expose
    private List<String> locationStatus = null;
    @SerializedName("locationTypes")
    @Expose
    private List<String> locationTypes = null;
    @SerializedName("saftyOffices")
    @Expose
    private List<SafteyOffices> saftyOffices = null;

    public List<String> getContractType() {
        return contractType;
    }

    public void setContractType(List<String> contractType) {
        this.contractType = contractType;
    }

    public List<LocationCategories> getLocationCategories() {
        return locationCategories;
    }

    public void setLocationCategories(List<LocationCategories> locationCategories) {
        this.locationCategories = locationCategories;
    }

    public List<String> getLocationStatus() {
        return locationStatus;
    }

    public void setLocationStatus(List<String> locationStatus) {
        this.locationStatus = locationStatus;
    }

    public List<String> getLocationTypes() {
        return locationTypes;
    }

    public void setLocationTypes(List<String> locationTypes) {
        this.locationTypes = locationTypes;
    }

    public List<SafteyOffices> getSaftyOffices() {
        return saftyOffices;
    }

    public void setSaftyOffices(List<SafteyOffices> saftyOffices) {
        this.saftyOffices = saftyOffices;
    }
}
