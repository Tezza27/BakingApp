package com.example.android.bakingapp.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;

import java.util.ArrayList;

public class FragmentStepDetail extends Fragment {
    private View rootview;
    private TextView stepDetailTV;
    private ArrayList<Step> stepArrayList;
    private ImageView backArrow;
    private ImageView forwardArrow;
    private int stepId;
    private int nextId;
    private String stepDescription;
    private int stepListSize;
    private int currentIndex;

       //Mandatory constructor for instantiating the fragment
    public FragmentStepDetail() {
   }

   //Inflate the fragment layout and set any image resources
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstantState){
         //Inflate the FragmentStepDetail layout
            rootview = inflater.inflate(R.layout.fragment_step_detail, container, false);

            //get a a reference to the views in the fragment layout
            stepDetailTV = (TextView) rootview.findViewById(R.id.step_detail_description_TV);
            backArrow = (ImageView) rootview.findViewById(R.id.back_arrow_button);
            forwardArrow = (ImageView) rootview.findViewById(R.id.forward_arrow_button);

            //unpack the bundle to get data sent from StepDetailActivity
            stepId = this.getArguments().getInt("STEP_ID");
            stepArrayList = this.getArguments().getParcelableArrayList("STEP_LIST");
            stepListSize = stepArrayList.size();
            stepDescription = this.getArguments().getString("STEP_DESCRIPTION");
            currentIndex = findIndex();
            setArrowVisibility(currentIndex);


            backArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleBackArrow(currentIndex);
                }
            });

            forwardArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    handleforwardArrow(currentIndex);
                }
            });

            //Set text to the view
            stepDetailTV.setText(stepDescription);
            return rootview;
        }

        private int handleBackArrow(int mCurrentIndex){
            currentIndex = mCurrentIndex - 1;
            populateTextView(currentIndex);
            setArrowVisibility(currentIndex);
            return currentIndex;
        }

    private int handleforwardArrow(int mCurrentIndex){
        currentIndex = mCurrentIndex + 1;
        populateTextView(currentIndex);
        setArrowVisibility(currentIndex);
        return currentIndex;

    }

    public View populateTextView(int currentIndex) {
        stepDetailTV.setText(stepArrayList.get(currentIndex).getmStepDescription());
        return rootview;

    }

    public void setArrowVisibility(int currentIndex){
        if(currentIndex<=0) {
            backArrow.setVisibility(View.INVISIBLE);
            forwardArrow.setVisibility(View.VISIBLE);
        }else if (currentIndex>=stepListSize-1){
            backArrow.setVisibility(View.VISIBLE);
            forwardArrow.setVisibility(View.INVISIBLE);
        }else{
            backArrow.setVisibility(View.VISIBLE);
            forwardArrow.setVisibility(View.VISIBLE);
        }
    }

      public int findIndex(){
            for(int i=0; i<stepListSize; i++){
                String mDesc = stepArrayList.get(i).getmStepDescription();
                int mstepId = stepArrayList.get(i).getmStepId();

                if( mDesc.equals(stepDescription) && mstepId==stepId){
                    currentIndex=i;
                    break;
                }
                }
            return currentIndex;
        }

}


