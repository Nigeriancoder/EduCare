package com.educare.educare;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;

    TextView questionNumber;
    TextView questionDetail;
    TextView textViewOptionA;
    TextView textViewOptionB;
    TextView textViewOptionC;
    TextView textViewOptionD;
    TextView textViewNextFinish;
    boolean textViewOptionAState = false;
    boolean textViewOptionBState = false;
    boolean textViewOptionCState = false;
    boolean textViewOptionDState = false;
    private int currentQuestion = 1;
    private String currentAnswer;

    int visual = 0;
    int audio = 0;
    int reading = 0;
    int kinesthetic = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        questionNumber = findViewById(R.id.question_number);
        questionDetail = findViewById(R.id.question_detail);
        textViewOptionA = findViewById(R.id.optionA);
        textViewOptionA.setOnClickListener(listener);
        textViewOptionB = findViewById(R.id.optionB);
        textViewOptionB.setOnClickListener(listener);
        textViewOptionC = findViewById(R.id.optionC);
        textViewOptionC.setOnClickListener(listener);
        textViewOptionD = findViewById(R.id.optionD);
        textViewOptionD.setOnClickListener(listener);
        textViewNextFinish = findViewById(R.id.next_finish);
        textViewNextFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });
    }

    private void nextQuestion() {
//        updating the score
        if (textViewOptionAState) {
            currentAnswer = "a";
        } else if (textViewOptionBState) {
            currentAnswer = "b";
        } else if (textViewOptionCState) {
            currentAnswer = "c";
        } else if (textViewOptionDState) {
            currentAnswer = "d";
        }

        // checking the appropriate model
        if (currentAnswer.equals("a")) {
            int optionId = getResources().getIdentifier("question" + currentQuestion + "OptionAModel", "string", "com.educare.educare");
            getResources().getString(optionId);
            updateScore(getResources().getString(optionId));
        } else if (currentAnswer.equals("b")) {
            int optionId = getResources().getIdentifier("question" + currentQuestion + "OptionBModel", "string", "com.educare.educare");
            getResources().getString(optionId);
            updateScore(getResources().getString(optionId));
        } else if (currentAnswer.equals("c")) {
            int optionId = getResources().getIdentifier("question" + currentQuestion + "OptionCModel", "string", "com.educare.educare");
            getResources().getString(optionId);
            updateScore(getResources().getString(optionId));
        } else if (currentAnswer.equals("d")) {
            int optionId = getResources().getIdentifier("question" + currentQuestion + "OptionDModel", "string", "com.educare.educare");
            getResources().getString(optionId);
            updateScore(getResources().getString(optionId));
        }
        deselectAllOptions();
        currentQuestion += 1;
        if (currentQuestion < 16) {
            String questionName = "question" + currentQuestion;
            questionNumber.setText("Question " + currentQuestion + ":");
            int questionId = getResources().getIdentifier(questionName, "string", "com.educare.educare");
            int questionOptionAId = getResources().getIdentifier(questionName + "OptionA", "string", "com.educare.educare");
            int questionOptionBId = getResources().getIdentifier(questionName + "OptionB", "string", "com.educare.educare");
            int questionOptionCId = getResources().getIdentifier(questionName + "OptionC", "string", "com.educare.educare");
            int questionOptionDId = getResources().getIdentifier(questionName + "OptionD", "string", "com.educare.educare");
            questionDetail.setText(questionId);
            textViewOptionA.setText(questionOptionAId);
            textViewOptionB.setText(questionOptionBId);
            textViewOptionC.setText(questionOptionCId);
            textViewOptionD.setText(questionOptionDId);
        } else {
            textViewNextFinish.setText("Finish");
            Toast.makeText(this, "visual - " + visual + "\naural - " + audio + "\nreading - " + reading + "\nkinesthetic - " + kinesthetic, Toast.LENGTH_LONG).show();
        }
    }

    private void updateScore(String model) {
        switch (model) {
            case "V":
                visual++;
                break;
            case "A":
                audio++;
                break;
            case "R":
                reading++;
                break;
            case "K":
                kinesthetic++;
                break;
        }
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            deselectAllOptions();
            switch (view.getId()) {
                case R.id.optionA:
                    textViewOptionAState = !textViewOptionAState;
                    textViewOptionBState = false;
                    textViewOptionCState = false;
                    textViewOptionDState = false;
                    view.setSelected(textViewOptionAState);
                    break;
                case R.id.optionB:
                    textViewOptionAState = false;
                    textViewOptionBState = !textViewOptionBState;
                    textViewOptionCState = false;
                    textViewOptionDState = false;
                    view.setSelected(textViewOptionBState);
                    break;
                case R.id.optionC:
                    textViewOptionAState = false;
                    textViewOptionBState = false;
                    textViewOptionCState = !textViewOptionCState;
                    textViewOptionDState = false;
                    view.setSelected(textViewOptionCState);
                    break;
                case R.id.optionD:
                    textViewOptionAState = false;
                    textViewOptionBState = false;
                    textViewOptionCState = false;
                    textViewOptionDState = !textViewOptionDState;
                    view.setSelected(textViewOptionDState);
                    break;
            }
        }
    };

    private void deselectAllOptions() {
        textViewOptionA.setSelected(false);
        textViewOptionB.setSelected(false);
        textViewOptionC.setSelected(false);
        textViewOptionD.setSelected(false);
    }
}
