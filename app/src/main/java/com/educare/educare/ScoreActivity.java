package com.educare.educare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    public static final String VISUAL_SCORE = "com.educare.educare.VISUAL_SCORE";
    public static final String AURAL_SCORE = "com.educare.educare.AURAL_SCORE";
    public static final String READING_SCORE = "com.educare.educare.READING_SCORE";
    public static final String KINESTHETIC_SCORE = "com.educare.educare.KINESTHETIC_SCORE";

    TextView textViewLearnerType;
    TextView textViewVisual;
    TextView textViewAural;
    TextView textViewReading;
    TextView textViewKinesthetic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int visualScore = bundle.getInt(VISUAL_SCORE);
        int auralScore = bundle.getInt(AURAL_SCORE);
        int readingScore = bundle.getInt(READING_SCORE);
        int kinestheticScore = bundle.getInt(KINESTHETIC_SCORE);

        textViewLearnerType = findViewById(R.id.textview_learnertype);
        textViewVisual = findViewById(R.id.textview_visual);
        textViewAural = findViewById(R.id.textview_aural);
        textViewReading = findViewById(R.id.textview_reading);
        textViewKinesthetic = findViewById(R.id.textview_kinesthetic);

        textViewVisual.setText("Visual = " + visualScore);
        textViewAural.setText("Aural = " + auralScore);
        textViewReading.setText("Reading = " + readingScore);
        textViewKinesthetic.setText("Kinesthetic = " + kinestheticScore);

        String max = "Visual";
        if (auralScore > visualScore){
            max = "Aural";
        }else if(readingScore > auralScore){
            max = "Reading";
        }else if(kinestheticScore > readingScore){
            max = "Kinesthetic";
        }

        textViewLearnerType.setText("You are a " + max + " Learner");
    }
}
