package com.example.significantfigurescalculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorButtons {
    public Button button;
    public String buttonType;
    public TextView typingArea;

    public CalculatorButtons (Button input, String inputType, TextView inputTypingArea) {
        button = input;
        buttonType = inputType;
        typingArea = inputTypingArea;

        button.setSoundEffectsEnabled(false);
        
        switch (buttonType) {
            // Subjects
            case "Math": case "Biology": case "Chemistry": case "Physics":
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        ButtonFunctions.changeSubject(buttonType);
                    }
                });
                break;
            // Digits
            case "zero0": case "one1": case "two2": case "three3": case "four4": case "five5": case "six6": case "seven7": case "eight8": case "nine9":
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        ButtonFunctions.addDigit(buttonType.charAt(buttonType.length() - 1) - '0', typingArea);
                    }
                });
                break;
            // Operation
            case "Addition": case "Subtraction": case "Multiplication": case "Division":
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        ButtonFunctions.equation(buttonType, typingArea);
                    }
                });
                break;
            // Equal Buttons
            case "equal":
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        ButtonFunctions.solveEquation(typingArea);
                    }
                });
                break;
            case "Delete":
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        ButtonFunctions.deleteLast(typingArea);
                    }
                });
                break;
            // Unassigned Buttons
            default :
                input.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                    }
                });
        }
    }
}
