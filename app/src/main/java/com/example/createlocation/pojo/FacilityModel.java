package com.example.createlocation.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class FacilityModel implements Parcelable {
    private String name;
    private int id;

    protected FacilityModel(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<FacilityModel> CREATOR = new Creator<FacilityModel>() {
        @Override
        public FacilityModel createFromParcel(Parcel in) {
            return new FacilityModel(in);
        }

        @Override
        public FacilityModel[] newArray(int size) {
            return new FacilityModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }

    @Override
    public String toString() {
        return "FacilityModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

