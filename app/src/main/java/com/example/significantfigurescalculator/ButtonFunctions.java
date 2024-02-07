package com.example.significantfigurescalculator;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.TextView;

public class ButtonFunctions {

    // Stored array of all buttons id
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

    // Stores every button from CalculatorButtons class
    public static CalculatorButtons[] buttons = new CalculatorButtons[button_id.length];

    // Container of sound files for every elements (0-4 index is for button sounds)
    public static MediaPlayer[] mediaPlayer = new MediaPlayer[4];

    public static String currentEquation = "";

    public static void changeSubject(String subject) {
        // Changes the custom functions on the side

    }

    public static void addDigit(int digit, TextView typingArea) {
        // Adds a digit to the equation with digit given

        // Here's an exemple of how to change what text is displayed on the screen
        currentEquation += digit;
        typingArea.setText(currentEquation);
    }

    public static void equation(String operation, TextView typingArea) {
        // Adds a operation to the equation

        // Here's an exemple of how to change what text is displayed on the screen
        switch(operation) {
            case "Addition": currentEquation += "+"; break;
            case "Substraction": currentEquation += "-"; break;
            case "Multiplication": currentEquation += "×"; break;
            case "Division": currentEquation += "/"; break;
        }
        typingArea.setText(currentEquation);
    }

    public static void solveEquation(TextView typingArea) {
        // Solve the current equation (This is not gonna be fun cause there isn't really an eval function...)

    }

    public static void deleteLast(TextView typingArea) {
        // Delete last input

        // Here's an exemple of how to change what text is displayed on the screen
        currentEquation = currentEquation.substring(0, currentEquation.length() - 1);
        typingArea.setText(currentEquation);
    }
}
