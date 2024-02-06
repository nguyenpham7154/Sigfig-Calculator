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
        for (int i = 0; i < ButtonFunctions.button_id.length; i++) {
            Button key = (Button)findViewById(ButtonFunctions.button_id[i]);
            key.setSoundEffectsEnabled(false);

            // Attributes function to each buttons
            String keyFunction = (getResources().getResourceEntryName(ButtonFunctions.button_id[i]));
            CalculatorButtons keySetup = new CalculatorButtons(key, keyFunction);
            ButtonFunctions.buttons[i] = keySetup;
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