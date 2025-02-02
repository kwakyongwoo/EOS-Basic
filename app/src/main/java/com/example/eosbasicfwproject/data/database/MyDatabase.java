package com.example.eosbasicfwproject.data.database;

import android.content.Context;

import com.example.eosbasicfwproject.data.entitiy.TodoItem;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {TodoItem.class})
public abstract class MyDatabase extends RoomDatabase {
    abstract public TodoDao todoDao();

    private static MyDatabase myDatabase;

    public static MyDatabase getInstance(Context context) {
        if(myDatabase == null) {
            myDatabase = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, "myDatabase.db")
                    .allowMainThreadQueries()
                    .build();
        }
        return myDatabase;
    }
}
