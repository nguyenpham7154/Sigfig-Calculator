package com.example.significantfigurescalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        // Textview of equation area
        TextView typingArea = (TextView) findViewById(R.id.typingArea);

        // Creates new button from CalculatorButton class
        for (int i = 0; i < ButtonFunctions.button_id.length; i++) {
            Button key = (Button)findViewById(ButtonFunctions.button_id[i]);
            String keyFunction = (getResources().getResourceEntryName(ButtonFunctions.button_id[i]));
            ButtonFunctions.buttons[i] = new CalculatorButtons(key, keyFunction, typingArea);
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