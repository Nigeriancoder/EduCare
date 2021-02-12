package com.educare.educare;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    TextView textViewFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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
        textViewFinish = findViewById(R.id.finish);
        textViewFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, LearningOption.class);
                startActivity(intent);
                finish();
            }
        });

        textViewVisual.setText("Visual = " + visualScore);
        textViewAural.setText("Aural = " + auralScore);
        textViewReading.setText("Reading = " + readingScore);
        textViewKinesthetic.setText("Kinesthetic = " + kinestheticScore);

        String max = "-";
        int maxScore = 0;
        int n = 0;
        while (n < 4) {
            if (n == 0) {
                if (visualScore > maxScore) {
                    max = "Visual";
                    maxScore = visualScore;
                }
            }
            else if (n == 1) {
                if (auralScore > maxScore) {
                    max = "Aural";
                    maxScore = auralScore;
                }
            } else if (n == 2) {
                if (readingScore > maxScore) {
                    max = "Reading";
                    maxScore = readingScore;
                }
            } else if (n==3) {
                if (kinestheticScore > maxScore) {
                    max = "Kinesthetic";
                    maxScore = kinestheticScore;
                }
            }
            n++;
        }

        textViewLearnerType.setText("You are a " + max + " Learner");
    }
}
