package com.shenkar.calculator;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

@Entity
public class birthdayEntity {


    @PrimaryKey (autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "date")
    public String date;

    public birthdayEntity(String name,String date){
        this.name = name;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDate() {

        String year;
        String month;
        String day;
        StringTokenizer st = new StringTokenizer(this.date,"-");
            year = st.nextToken();
            month = st.nextToken();
            day = st.nextToken();

            return day + "/" + month + "/" + year;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
