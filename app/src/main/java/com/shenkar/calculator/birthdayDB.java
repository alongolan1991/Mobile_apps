package com.shenkar.calculator;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {birthdayEntity.class},version = 1)
public abstract class birthdayDB extends RoomDatabase {
    public abstract birthdayDao bdDao();
}
