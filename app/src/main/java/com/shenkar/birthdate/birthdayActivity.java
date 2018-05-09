package com.shenkar.birthdate;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.shenkar.calculator.R;
import com.shenkar.calculator.birthdayDB;
import com.shenkar.calculator.birthdayEntity;

import java.util.Calendar;

public class birthdayActivity extends AppCompatActivity {

    long datel;

    private static final String TAG = "birthdayActivity";


    EditText Name ;
   birthdayDB db;
    String date;
   DatePickerDialog.OnDateSetListener mDate;
    TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday2);
        Name = findViewById(R.id.bdName);
        mText = findViewById(R.id.select);
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal  = Calendar.getInstance();
                int year =  cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day =  cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(birthdayActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDate,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month += 1;
//                 date = dayOfMonth + "/" + month  + "/" + year ;
                    date = year +"-"+month+"-"+dayOfMonth;
                mText.setText(date);
            }
        };

        db = Room.databaseBuilder(getApplicationContext(),birthdayDB.class, "mydb8.db").allowMainThreadQueries().build();
    }

    public void addtodb(View view) {
        String check = mText.getText().toString();
        if(check.equals("select date") || Name.getText().toString().equals(""))
            return;
       db.bdDao().insertAll(new birthdayEntity(Name.getText().toString(),mText.getText().toString()));
        }

    public void gotolist(View view) {
        Intent intent = new Intent(this, birthdaylist.class);
        startActivity(intent);
    }
}

