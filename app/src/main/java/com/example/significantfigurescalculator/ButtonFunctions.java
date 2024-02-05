package com.example.significantfigurescalculator;

import android.content.Context;
import android.media.MediaPlayer;

public class ButtonFunctions {
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
            R.id.plusMinus, R.id.decimal, R.id.equal
    };

    // Container of sound files for every elements (0-4 index is for button sounds)
    public static MediaPlayer[] mediaPlayer = new MediaPlayer[4];

    public static String currentEquation = "";

    public static void changeSubject(String subject) {
        // Changes the custom functions on the side

    }

    public static void addDigit(int digit) {
        // Adds a digit to the equation with digit given

    }

    public static void equation(String operation) {
        // Adds a operation to the equation

    }

    public static void solveEquation() {
        // Solve the current equation

    }

    public static void deleteLast() {
        // Delete last input

    }
}
