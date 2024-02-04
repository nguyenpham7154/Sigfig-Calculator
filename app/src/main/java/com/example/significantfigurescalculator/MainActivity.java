package com.example.significantfigurescalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Id of all buttons on calculators (Finding id through strings is more work...)
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
    public MediaPlayer[] mediaPlayer = new MediaPlayer[4];

    // This function has to be called after the activity is created or the app crashes
    public void setButtonSound() {
        mediaPlayer[0] = MediaPlayer.create(this,R.raw.button_press_1);
        mediaPlayer[1] = MediaPlayer.create(this,R.raw.button_press_2);
        mediaPlayer[2] = MediaPlayer.create(this,R.raw.button_press_3);
        mediaPlayer[3] = MediaPlayer.create(this,R.raw.button_press_4);
    }

    public void setButtonFunctions() {
        // Initializes sound
        setButtonSound();

        // Sets property for each type of buttons
        for (int id : button_id) {
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
                            mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            changeSubject((getResources().getResourceEntryName(v.getId())));
                        }
                    });
                    break;
                // Digits
                case "zero0": case "one1": case "two2": case "three3": case "four4": case "five5": case "six6": case "seven7": case "eight8": case "nine9":
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                            String keyFunction = (getResources().getResourceEntryName(v.getId()));
                            addDigit(keyFunction.charAt(keyFunction.length() - 1) - '0');
                        }
                    });
                    break;
                // Unassigned Buttons
                default :
                    key.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mediaPlayer[(int)(Math.random() * 4)].start(); // Play Sound
                        }
                    });
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

        // Sets buttons
        setButtonFunctions();
    }
}