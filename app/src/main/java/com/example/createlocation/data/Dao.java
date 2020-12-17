package com.example.createlocation.data;

import android.icu.text.Replaceable;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.createlocation.pojo.CreateLocationDB;

import java.util.List;

import retrofit2.http.DELETE;

import static androidx.room.OnConflictStrategy.REPLACE;
@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = REPLACE)
    void insertData(CreateLocationDB createLocationDB);
    @Query("SELECT * FROM create_location")
    List<CreateLocationDB> getData();
    @Delete
    void deleteLocation(CreateLocationDB createLocationDB);
}
