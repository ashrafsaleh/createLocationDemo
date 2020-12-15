package com.example.createlocation.data;

import android.icu.text.Replaceable;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.createlocation.pojo.CreateLocationDB;

import static androidx.room.OnConflictStrategy.REPLACE;
@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = REPLACE)
    long insertData(CreateLocationDB createLocationDB);
    @Query("SELECT * FROM create_location")
    CreateLocationDB getData();
}
