package com.shenkar.birthdate;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shenkar.birthdate.UserAdapter;
import com.shenkar.calculator.R;
import com.shenkar.calculator.birthdayDB;
import com.shenkar.calculator.birthdayEntity;

import java.util.List;

public class birthdaylist extends AppCompatActivity {

    RecyclerView mylist;
    RecyclerView.Adapter adapter;
    birthdayDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdaylist);
        mylist = findViewById(R.id.bdlist);

        db = Room.databaseBuilder(getApplicationContext(),birthdayDB.class, "mydb8.db").allowMainThreadQueries().build();

        List<birthdayEntity> birthDay = db.bdDao().getallbirthdate();

        mylist.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserAdapter(birthDay);
        mylist.setAdapter(adapter);
    }
}
