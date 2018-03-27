package com.shenkar.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView calc;
    private int first_num;
    private int second_num;
    private String action;
    private String temp;
    private int result = 555555;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = findViewById(R.id.calcView);


    }


    public void onNumberClick(View view) {
        Object tag = view.getTag();

        if ("num".equals(tag)) {
            temp = (String) calc.getText();
            if ("*".equalsIgnoreCase(temp) || "+".equalsIgnoreCase(temp) || "/".equalsIgnoreCase(temp) || "-".equalsIgnoreCase(temp)) {
                calc.setText("0");
            }
            String digitClicked = (String) ((Button) view).getText();
            String currentText = (String) calc.getText();
            int currentValue = Integer.parseInt(currentText);
            int newValue = 10 * currentValue + Integer.parseInt(digitClicked);
            calc.setText(String.valueOf(newValue));
        } else if ("action".equals(tag)) {
            if (result == 555555) {
                result = Integer.parseInt((String) calc.getText());
                action = (String) ((Button) view).getText();
                calc.setText(String.valueOf(action));
                return;
            }
            if (action == "") {
                action = (String) ((Button) view).getText();
                calc.setText(String.valueOf(action));
                return;
            }
            try {
                second_num = Integer.parseInt((String) calc.getText());
            } catch (Exception e) {
                second_num = 0;
            }


            calc.setText(String.valueOf(action));

            if ("+".equalsIgnoreCase(action)) {
                result = result + second_num;
            } else if ("-".equalsIgnoreCase(action)) {
                result = result - second_num;
            } else if ("*".equalsIgnoreCase(action)) {
                result = result * second_num;
            } else if ("/".equalsIgnoreCase(action)) {
                try {
                    result = result / second_num;
                }
                catch(Exception e){
                    return;
                }
            }
            action = (String) ((Button) view).getText();
            calc.setText(String.valueOf(action));
        } else if ("result".equals(tag)) {
            int second_num1;
            try {
                second_num1 = Integer.parseInt((String) calc.getText());
            } catch (Exception e) {
                return;
            }
            if ("+".equalsIgnoreCase(action)) {
                result = result + second_num1;
            } else if ("/".equalsIgnoreCase(action)) {
                try {
                    result = result / second_num1;
                } catch (Exception e) {
                    return;
                }
            } else if ("-".equalsIgnoreCase(action)) {
                result = result - second_num1;
            } else if ("*".equalsIgnoreCase(action)) {
                result = result * second_num1;
            }

            calc.setText(String.valueOf(result));
            action = "";
        } else if ("clear".equals(tag)) {
            result = 555555;
            action = "";
            second_num = 0;
            calc.setText("0");

        }
    }
}
