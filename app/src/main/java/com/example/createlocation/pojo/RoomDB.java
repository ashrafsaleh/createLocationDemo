package com.example.createlocation.pojo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {CreateLocationDB.class},version = 1)
public abstract class RoomDB  extends RoomDatabase {
    public static RoomDB db;
    public static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context){
        if(db == null){
            db = Room.databaseBuilder(context.getApplicationContext(),RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigrationOnDowngrade()
                    .build();
        }
        return db;
    }

}
