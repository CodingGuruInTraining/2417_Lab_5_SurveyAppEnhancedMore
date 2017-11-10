package com.example.hl4350hb.surveyapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 *
 */

public class MainFragment extends Fragment {

    private MainScreenListener mMainScreenListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainScreenListener) {
            mMainScreenListener = (MainScreenListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement MainScreenListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        TextView surveyQuestion = (TextView) view.findViewById(R.id.survey_questions);
        // todo finish adding widgets if works

        return view;
    }

    public interface MainScreenListener {
        void mainLoaded();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }
}
