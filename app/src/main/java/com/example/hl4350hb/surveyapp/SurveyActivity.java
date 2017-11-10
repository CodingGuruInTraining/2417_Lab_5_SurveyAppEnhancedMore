package com.example.hl4350hb.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SurveyActivity extends AppCompatActivity {

    // Initialize variables to hold widget objects.
    EditText newQuestion;
    EditText option1;
    EditText option2;
    Button createBtn;

    // Static tags for returning Extras.
    public static final String EXTRA_FROM_SURVEY_QUESTION = "who wants a new question";
    public static final String EXTRA_FROM_SURVEY_OPT1 = "I have an option you cant refuse";
    public static final String EXTRA_FROM_SURVEY_OPT2 = "I choose option 3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        // References the received Intent.
        Intent launchIntent = getIntent();

        // Defines widgets.
        newQuestion = (EditText) findViewById(R.id.new_question);
        option1 = (EditText) findViewById(R.id.option_1);
        option2 = (EditText) findViewById(R.id.option_2);
        createBtn = (Button) findViewById(R.id.submit_button);

        // Create button's click event.
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieves the values from EditText widgets.
                String question = newQuestion.getText().toString();
                String opt1 = option1.getText().toString();
                String opt2 = option2.getText().toString();

                // Checks that all fields are filled before continuing.
                if (question.equals("") || opt1.equals("") || opt2.equals("")) {
                    // Displays Toast if at least one field is empty.
                    Toast.makeText(SurveyActivity.this, "Please fill in all fields before submitting", Toast.LENGTH_SHORT).show();
                } else {
                    // Creates new Intent to return to MainActivity.
                    Intent surveyIntent = new Intent();
                    // Adds string values to Extra.
                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_QUESTION, question);
                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_OPT1, opt1);
                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_OPT2, opt2);
                    setResult(RESULT_OK, surveyIntent);
                    finish();
                }
            }
        });
    }
}
