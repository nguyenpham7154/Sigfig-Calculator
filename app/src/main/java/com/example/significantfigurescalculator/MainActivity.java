package com.example.significantfigurescalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // This function has to be called after the activity is created or the app crashes
    public void setButtonSound() {
        ButtonFunctions.mediaPlayer[0] = MediaPlayer.create(this,R.raw.button_press_1);
        ButtonFunctions.mediaPlayer[1] = MediaPlayer.create(this,R.raw.button_press_2);
        ButtonFunctions.mediaPlayer[2] = MediaPlayer.create(this,R.raw.button_press_3);
        ButtonFunctions.mediaPlayer[3] = MediaPlayer.create(this,R.raw.button_press_4);
    }

    public void setButtonFunctions() {
        // Initializes sound
        setButtonSound();

        // Sets property for each type of buttons
        for (int id : ButtonFunctions.button_id) {
            Button key = (Button)findViewById(id);
            key.setSoundEffectsEnabled(false);

            // Attributes function to each buttons
            String keyFunction = (getResources().getResourceEntryName(id));
            switch (keyFunction) {
                // Subjects
                case "Math": case "Biology": case "Chemistry": case "Physics":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            ButtonFunctions.changeSubject((getResources().getResourceEntryName(v.getId())));
                        }
                    });
                    break;
                // Digits
                case "zero0": case "one1": case "two2": case "three3": case "four4": case "five5": case "six6": case "seven7": case "eight8": case "nine9":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            String keyFunction = (getResources().getResourceEntryName(v.getId()));
                            ButtonFunctions.addDigit(keyFunction.charAt(keyFunction.length() - 1) - '0');
                        }
                    });
                    break;
                // Operation
                case "Addition": case "Subtraction": case "Multiplication": case "Division":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            ButtonFunctions.equation((getResources().getResourceEntryName(v.getId())));
                        }
                    });
                    break;
                // Equal Buttons
                case "equal":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            ButtonFunctions.solveEquation();
                        }
                    });
                    break;
                case "Delete":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            ButtonFunctions.deleteLast();
                        }
                    });
                    break;
                // Unassigned Buttons
                default :
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ButtonFunctions.mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        }
                    });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sets buttons
        setButtonFunctions();
    }
}