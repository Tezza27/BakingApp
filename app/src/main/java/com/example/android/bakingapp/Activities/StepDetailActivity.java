package com.example.android.bakingapp.Activities;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.android.bakingapp.Fragments.FragmentExoplayer;
import com.example.android.bakingapp.Fragments.FragmentStepDetail;
import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;

import java.util.ArrayList;


public class StepDetailActivity extends AppCompatActivity {

    private ExoPlayer mExoPlayer;
    private PlayerView mExoPlayerView;
    public ArrayList<Step> stepList;
    int stepId;
    String stepDescription;
    String stepVideoUrl;

    ImageView backArrow;
    ImageView forewardArrow;

    int stepListSize;
    int nextId;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_detail);

        mExoPlayerView = (PlayerView) findViewById(R.id.exoplayer_view);
        stepList = new ArrayList<Step>();
        stepList=getIntent().getExtras().getParcelableArrayList("step_list");
        stepId = getIntent().getExtras().getInt("stepID");
        stepDescription = getIntent().getExtras().getString("description");
        stepVideoUrl = getIntent().getExtras().getString("videoURL");

        sendDataToStepDetailFragment();
        sendDataToExoplayerFragment();

        //Create new FragmentExoplayer and FragmentStepDetail instances and display them using the FragmentManager
        FragmentExoplayer exoPlayerFragment = new FragmentExoplayer();
        exoPlayerFragment.setArguments(bundle);

        FragmentStepDetail stepDetailFragment = new FragmentStepDetail();
        stepDetailFragment.setArguments(bundle);

        //Use a FragmentManager and transaction to add the fragment to the screen
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Fragment transaction
        fragmentManager.beginTransaction()
                .add(R.id.exoplayer_container, exoPlayerFragment)
                .add(R.id.step_detail_container, stepDetailFragment)
                .commit();

    }

    private void sendDataToStepDetailFragment(){
        bundle = new Bundle();
        bundle.putInt("STEP_ID", stepId);
        bundle.putString("STEP_DESCRIPTION", stepDescription);
        bundle.putParcelableArrayList("STEP_LIST", stepList);

    }

    private void sendDataToExoplayerFragment() {
        bundle = new Bundle();
        bundle.putString("STEP_VIDEO_URL", stepVideoUrl);

    }

}
