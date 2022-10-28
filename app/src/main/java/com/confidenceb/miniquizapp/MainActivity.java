package com.confidenceb.miniquizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tquest, questions;
    Button optA,optB,optC,optD,submitBtn;

    int score = 0;
    int tquestions = QuestionsAndAnswers.questions.length;
    int currentQuestIndex = 0;
    String selectedOption = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tquest = findViewById(R.id.total_questions);
        questions = findViewById(R.id.questions);
        optA = findViewById(R.id.option_A);
        optB = findViewById(R.id.option_B);
        optC = findViewById(R.id.option_C);
        optD = findViewById(R.id.option_D);
        submitBtn = findViewById(R.id.subit_btn);

        optA.setOnClickListener(this);
        optB.setOnClickListener(this);
        optC.setOnClickListener(this);
        optD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        tquest.setText("Number of questions: "+tquestions);

        loadQuestions();

    }

    private void loadQuestions() {
        questions.setText(QuestionsAndAnswers.questions[currentQuestIndex]);
        optA.setText(QuestionsAndAnswers.options[currentQuestIndex][0]);
        optB.setText(QuestionsAndAnswers.options[currentQuestIndex][1]);
        optC.setText(QuestionsAndAnswers.options[currentQuestIndex][2]);
        optD.setText(QuestionsAndAnswers.options[currentQuestIndex][3]);
    }

    @Override
    public void onClick(View view) {

        optA.setBackgroundColor(ContextCompat.getColor(this, R.color.RaspBerry));
        optB.setBackgroundColor(ContextCompat.getColor(this, R.color.RaspBerry));
        optC.setBackgroundColor(ContextCompat.getColor(this, R.color.RaspBerry));
        optD.setBackgroundColor(ContextCompat.getColor(this, R.color.RaspBerry));

        Button clickedBtn = (Button) view;
        if(clickedBtn.getId()== R.id.subit_btn){
            currentQuestIndex++;
            loadQuestions();

            if(selectedOption.equals(QuestionsAndAnswers.answers[currentQuestIndex])){
                score++;
            }

        }else{
            selectedOption = clickedBtn.getText().toString();
            clickedBtn.setBackgroundColor(Color.RED);
        }
    }
}