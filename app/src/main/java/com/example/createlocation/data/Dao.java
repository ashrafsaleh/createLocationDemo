package com.example.createlocation.data;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.createlocation.pojo.CreateLocationDB;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;
@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = REPLACE)
    void insertData(CreateLocationDB createLocationDB);
    @Query("SELECT * FROM create_location")
    List<CreateLocationDB> getData();
    @Delete
    void deleteLocation(CreateLocationDB createLocationDB);
    @Update
    void updateData(CreateLocationDB createLocationDB);
}
