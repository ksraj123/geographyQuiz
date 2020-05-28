package com.example.android.geographyquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] correctAnswers  = new String[] {"The border between Nepal and India", "0101", "Canada", "china"};
    private String[] userAnswers = new String[correctAnswers.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int getScore(){
        int score = 0;
        for (int i = 0; i < this.correctAnswers.length; i++){
            if (correctAnswers[i].equals(userAnswers[i]))
                score++;
        }
        return score;
    }

    private String checkboxResponse(){
        CheckBox[] options = new CheckBox[4];
        options[0] = findViewById(R.id.question_2_1);
        options[1] = findViewById(R.id.question_2_2);
        options[2] = findViewById(R.id.question_2_3);
        options[3] = findViewById(R.id.question_2_4);
        String q2_userResponse = "";
        for (int i = 0; i < options.length; i++){
            if(options[i].isChecked()){
                q2_userResponse += "1";
            } else {
                q2_userResponse += "0";
            }
        }
        return q2_userResponse;
    }

    public void submit(View view){
        // Question 1
        RadioGroup question1 = (RadioGroup) findViewById(R.id.question_1);
        RadioButton question1_btn = (RadioButton) question1.findViewById(question1.getCheckedRadioButtonId());
        userAnswers[0] =  question1_btn.getText().toString();

        // Question 2
        userAnswers[1] = checkboxResponse();

        // Question 3
        RadioGroup question3 = (RadioGroup) findViewById(R.id.question_3);
        RadioButton question3_btn = (RadioButton) question3.findViewById(question3.getCheckedRadioButtonId());
        userAnswers[2] =  question3_btn.getText().toString();

        // Question 4
        EditText question4 = (EditText) findViewById(R.id.question_4);
        String q4Input = question4.getText().toString();
        q4Input = q4Input.toLowerCase();
        q4Input = q4Input.trim();
        userAnswers[3] = q4Input;

        // show score
        int score = getScore();
        TextView scoreDisp = (TextView) findViewById(R.id.score_display);
        scoreDisp.setText("" + score);
    }

}
