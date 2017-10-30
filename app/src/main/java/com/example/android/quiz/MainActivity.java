package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the submit button is tapped.
     */
    public void submit(View view) {
        scoreQuestionOne();
        scoreQuestionTwo();
        scoreQuestionThree();
        scoreQuestionFour();
        displayScore();
        score = 0;
    }

    /**
     * Checks the answer selected for question one and updates the score.
     */
    private void scoreQuestionOne() {
        RadioButton questionOneOptionB = findViewById(R.id.question_one_option_b);
        if (questionOneOptionB.isChecked()) {
            score++;
        }
    }

    /**
     * Checks the answer selected for question two and updates the score.
     */
    private void scoreQuestionTwo() {
        EditText questionTwoEditText = findViewById(R.id.question_two_edit_text);
        if (questionTwoEditText.getText().toString().equals("1999")) {
            score++;
        }
    }

    /**
     * Checks the answer selected for question three and updates the score.
     */
    private void scoreQuestionThree() {
        CheckBox questionThreeOptionA = findViewById(R.id.question_three_option_a);
        CheckBox questionThreeOptionB = findViewById(R.id.question_three_option_b);
        CheckBox questionThreeOptionC = findViewById(R.id.question_three_option_c);

        if (questionThreeOptionA.isChecked()
                && questionThreeOptionB.isChecked()
                && questionThreeOptionC.isChecked()) {
            score++;
        }
    }

    /**
     * Checks the answer selected for question four and updates the score.
     */
    private void scoreQuestionFour() {
        RadioButton questionFourOptionC = findViewById(R.id.question_four_option_c);
        if (questionFourOptionC.isChecked()) {
            score++;
        }
    }

    /**
     * Displays the score in a Toast.
     */
    private void displayScore() {
        String message = getMessage();
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String getMessage() {
        String message = "You scored " + score + " out of 4.";
        if (score < 2) {
            message += " Try again!";
        } else if (score < 3) {
            message += " Not bad.";
        } else if (score < 4) {
            message += " Well done.";
        } else {
            message += " Excellent!";
        }
        return message;
    }
}
