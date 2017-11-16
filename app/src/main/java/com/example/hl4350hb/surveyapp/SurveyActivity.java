package com.example.hl4350hb.surveyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SurveyActivity extends Fragment {

//    // Initialize variables to hold widget objects.
//    EditText newQuestion;
//    EditText option1;
//    EditText option2;
//    Button createBtn;

    // Static tags for returning Extras.
    public static final String EXTRA_FROM_SURVEY_QUESTION = "who wants a new question";
    public static final String EXTRA_FROM_SURVEY_OPT1 = "I have an option you cant refuse";
    public static final String EXTRA_FROM_SURVEY_OPT2 = "I choose option 3";
    public final static String NEW_SURVEY_KEY = "you will never guess what I surveyed";

    private NewSurveyScreenListener mNewSurveyScreenListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewSurveyScreenListener) {
            mNewSurveyScreenListener = (NewSurveyScreenListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ResultScreenListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_survey, container, false);

        // Defines widgets.
        final EditText newQuestion = (EditText) view.findViewById(R.id.new_question);
        final EditText option1 = (EditText) view.findViewById(R.id.option_1);
        final EditText option2 = (EditText) view.findViewById(R.id.option_2);
        Button createBtn = (Button) view.findViewById(R.id.submit_button);


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = newQuestion.getText().toString();
                String opt1 = option1.getText().toString();
                String opt2 = option2.getText().toString();

                // Checks that all fields are filled before continuing.
                if (question.equals("") || opt1.equals("") || opt2.equals("")) {
                    // Displays Toast if at least one field is empty.
                    Toast.makeText(container.getContext(), "Please fill in all fields before submitting", Toast.LENGTH_SHORT).show();
                } else {
                    String[] newSurveyStrings = {question, opt1, opt2};
                    mNewSurveyScreenListener.newSurveyCreated(newSurveyStrings);
                }
            }
        });


        return view;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_survey);
//
////        // References the received Intent.
////        Intent launchIntent = getIntent();
//
//        // Defines widgets.
//        newQuestion = (EditText) findViewById(R.id.new_question);
//        option1 = (EditText) findViewById(R.id.option_1);
//        option2 = (EditText) findViewById(R.id.option_2);
//        createBtn = (Button) findViewById(R.id.submit_button);
//
//        // Create button's click event.
//        createBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Retrieves the values from EditText widgets.
//                String question = newQuestion.getText().toString();
//                String opt1 = option1.getText().toString();
//                String opt2 = option2.getText().toString();
//
//                // Checks that all fields are filled before continuing.
//                if (question.equals("") || opt1.equals("") || opt2.equals("")) {
//                    // Displays Toast if at least one field is empty.
//                    Toast.makeText(SurveyActivity.this, "Please fill in all fields before submitting", Toast.LENGTH_SHORT).show();
//                } else {
////                    // Creates new Intent to return to MainActivity.
////                    Intent surveyIntent = new Intent();
////                    // Adds string values to Extra.
////                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_QUESTION, question);
////                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_OPT1, opt1);
////                    surveyIntent.putExtra(EXTRA_FROM_SURVEY_OPT2, opt2);
////                    setResult(RESULT_OK, surveyIntent);
////                    finish();
//
//
//                    String[] newSurveyStrings = {question, opt1, opt2};
//                    Bundle bundle = new Bundle();
//                    bundle.putStringArray(NEW_SURVEY_KEY, newSurveyStrings);
//
//
//
//                }
//            }
//        });
//    }

    public interface NewSurveyScreenListener {
        void newSurveyCreated(String[] newSurvey);
    }

    public static SurveyActivity newInstance() {
        return new SurveyActivity();
    }
}
