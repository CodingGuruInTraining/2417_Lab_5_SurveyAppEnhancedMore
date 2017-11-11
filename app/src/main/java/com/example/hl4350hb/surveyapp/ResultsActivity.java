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
import android.widget.TextView;

public class ResultsActivity extends Fragment {

    private ResultScreenListener mResultScreenListener;

    // Static tag for accessing returned Extra.
    public static final String EXTRA_FROM_RESULT = "here is a delicious extra";
    private static final String RESULT_ARGUMENTS_YES = "all the yeses";
    private static final String RESULT_ARGUMENTS_NO = "no no no no no";
    private static final String RESULT_ARGUMENTS_Q = "too many questions";


    private static int yesCount;
    private static int noCount;
    private static String question;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ResultScreenListener) {
            mResultScreenListener = (ResultScreenListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ResultScreenListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_results, container, false);

        TextView yesView = (TextView) view.findViewById(R.id.yeses);
        TextView noView = (TextView) view.findViewById(R.id.noes);
        Button resetBtn = (Button) view.findViewById(R.id.reset_button);
        Button contBtn = (Button) view.findViewById(R.id.continue_button);

// todo make dynamic once passing option values
        yesView.setText("Total Yes's: " + yesCount);
        noView.setText("Total No's: " + noCount);


        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultScreenListener.resetSurvey(true);
            }
        });

        contBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultScreenListener.resetSurvey(false);
            }
        });


        return view;
    }


    public interface ResultScreenListener {
        void resetSurvey(boolean resetCounts);
    }

    public static ResultsActivity newInstance(int yes, int no, String quest) {
        yesCount = yes;
        noCount = no;
        question = quest;
//        final Bundle args = new Bundle();
//        args.putParcelable(RESULT_ARGUMENTS_YES, yesCount);
//        args.putParcelable(RESULT_ARGUMENTS_NO, noCount);
//        args.putParcelable(RESULT_ARGUMENTS_Q, question);
//        final ResultsActivity fragment = new ResultsActivity();
//        fragment.setArguments(args);

//        return fragment;
        return new ResultsActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mResultScreenListener = null;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_results);
//
//        // Get reference to the Intent that launched this activity.
//        Intent launchIntent = getIntent();
//
//        // Retrieves counts and button values from MainActivity.
//        int yesCount = launchIntent.getIntExtra(MainActivity.YES_KEY, 0);
//        int noCount = launchIntent.getIntExtra(MainActivity.NO_KEY, 0);
//        String option1 = launchIntent.getStringExtra(MainActivity.OPT1_KEY);
//        String option2 = launchIntent.getStringExtra(MainActivity.OPT2_KEY);
//
//        // References widgets.
//        TextView yesView = (TextView) findViewById(R.id.yeses);
//        TextView noView = (TextView) findViewById(R.id.noes);
//        Button resetBtn = (Button) findViewById(R.id.reset_button);
//        Button contBtn = (Button) findViewById(R.id.continue_button);
//
//        // Uses default values if nothing was passed.
//        if (option1 == null || option2 == null) {
//            option1 = "Yes";
//            option2 = "No";
//        }
//
//        // Updates TextViews with received counts.
//        yesView.setText("Total " + option1 + "'s: " + yesCount);
//        noView.setText("Total " + option2 + "'s: " + noCount);
//
//        // Reset button's click event.
//        resetBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Runs return Intent function.
//                returnIntent(false);
//            }
//        });
//
//        // Continue button's click event.
//        contBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Runs return Intent function.
//                returnIntent(true);
//            }
//        });
//    }
//
//    private void returnIntent(boolean decision) {
//        // Creates new Intent for returning to MainActivity.
//        Intent resultIntent = new Intent();
//        // Passes received boolean back to MainActivity.
//        resultIntent.putExtra(EXTRA_FROM_RESULT, decision);
//        setResult(RESULT_OK, resultIntent);
//        finish();
//    }
}
