package com.example.significantfigurescalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static int[] button_id = {
            // Subjects
            R.id.Math, R.id.Biology, R.id.Chemistry, R.id.Physics,
            // Basic Functions
            R.id.DegreesOrRadian, R.id.Clear, R.id.Delete,
            // Operation Buttons
            R.id.Addition, R.id.Substraction, R.id.Multiplication, R.id.Division,
            // Digits Buttons
            R.id.zero0, R.id.one1, R.id.two2, R.id.three3, R.id.four4,
            R.id.five5, R.id.six6, R.id.seven7, R.id.eight8, R.id.nine9,
            // Custom Functions
            R.id.Function1, R.id.Function2, R.id.Function3, R.id.Function4,
            // Others
            R.id.plusMinus, R.id.decimal
    };

    public void setButtonFunctions() {
        for (int id : button_id) {
            Button key = (Button)findViewById(id);

            String keyFunction = (getResources().getResourceEntryName(id));
            switch (keyFunction) {
                case "Math":
                case "Biology":
                case "Chemistry":
                case "Physics":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            changeSubject((getResources().getResourceEntryName(v.getId())));
                        }
                    });
                    break;
                case "zero0":
                case "one1":
                case "two2":
                case "three3":
                case "four4":
                case "five5":
                case "six6":
                case "seven7":
                case "eight8":
                case "nine9":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String keyFunction = (getResources().getResourceEntryName(v.getId()));
                            addDigit(keyFunction.charAt(keyFunction.length() - 1) - '0');
                        }
                    });
                    break;
            }

        }
    }

    public void changeSubject(String subject) {
        // Changes the custom functions on the side

    }

    public static void addDigit(int digit) {
        // Adds a digit to the equation with digit given

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}