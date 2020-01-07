package com.mehul.higherorlower;

/*
    Title: Higher or Lower
    Description: Guessing game app that requires user to input/guess a number between 1-20
    Author: Mehul Patel
    Date: 12/11/2019
 */

import androidx.appcompat.app.AppCompatActivity;
        import java.util.*;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int rnum = (int) (Math.random() * ((20-1)+1)) + 1;      //a global variable to hold the random number generated
    public int counter = 0;                                        //a global variable to hold the counter

    public void makeToast(String str){
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    //method to run when the button is presseed
    public void clickFunction(View view){
        Button button = (Button)findViewById(R.id.guessButton);
        button.setText("Guess");                                        //sets the button text to Guess every time button is pressed

        EditText numInput = (EditText) findViewById(R.id.numText);
        int numEntered = Integer.parseInt(numInput.getText().toString());           //set text entered by user to integer

        //conditions set to determine if the number is too high or low
        if(numEntered > rnum) {
            if(numEntered > 20){
                makeToast("Invalid: Number is out of range. Enter another number between 1 - 20.");
                numInput.getText().clear();
                button.setText("Guess again");
                counter++;
            }else {
                Log.i("Info:", "Too high.");
                makeToast("Too high. Enter another number.");
                numInput.getText().clear();
                button.setText("Guess again");
                counter++;
            }

            Log.i("Info:", "Too high.");

        }else if(numEntered < rnum){
            if(numEntered < 1){
                makeToast("Number is out of range. Enter another number between 1 - 20.");
                numInput.getText().clear();
                button.setText("Guess again");
                counter++;
            }else {
               makeToast("Too low. Enter another number.");
                numInput.getText().clear();
                button.setText("Guess again");
                counter++;
            }

            Log.i("Info:", "Too low.");

        //sets button text to play again if correct number is selected and displays the number of attempts and generates a new random number
        }else if(numEntered == rnum) {
            makeToast("You got it in " + counter + " tries! " + "The number was: " + rnum);
            button.setText("Play again");
            numInput.getText().clear();
            rnum = (int) (Math.random() * ((20 - 1) + 1)) + 1;

            Log.i("Info:", "Correct.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
