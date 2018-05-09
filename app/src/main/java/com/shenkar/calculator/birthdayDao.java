package com.shenkar.calculator;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface birthdayDao {
    @Query("SELECT * FROM birthdayentity ORDER BY SUBSTR(DATE('NOW'), 6)>SUBSTR(date, 6), SUBSTR(date, 6) DESC"   )
    List<birthdayEntity> getallbirthdate();

    @Insert
    void insertAll(birthdayEntity birthday);
}
