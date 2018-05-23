package com.shenkar.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.shenkar.animation.AnimationActivity1;
import com.shenkar.birthdate.birthdayActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void move_to_calc(View view) {
        Intent intent = new Intent(this, calculator.class);
        startActivity(intent);
    }

    public void move_to_birth(View view) {
        Intent intent = new Intent(this, birthdayActivity.class);
        startActivity(intent);
    }

    public void move_to_anim(View view) {
        Intent intent = new Intent(this, AnimationActivity1.class);
        startActivity(intent);
    }
}
