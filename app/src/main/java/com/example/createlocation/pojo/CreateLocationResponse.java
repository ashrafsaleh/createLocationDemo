package com.example.createlocation.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateLocationResponse {
    @SerializedName("result")
    @Expose
    private int result;
    @SerializedName("loc")
    @Expose
    private CreateLocationModel loc ;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public CreateLocationModel getLoc() {
        return loc;
    }

    public void setLoc(CreateLocationModel loc) {
        this.loc = loc;
    }
}
