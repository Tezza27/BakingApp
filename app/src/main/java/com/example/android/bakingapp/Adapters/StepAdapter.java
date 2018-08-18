package com.example.android.bakingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakingapp.Activities.StepDetailActivity;
import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;

import java.util.ArrayList;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {
    private Context mContext;
    private ArrayList<Step> mStepList;
    private ArrayList<Ingredient>mIngredientList;

    public StepAdapter(Context context, ArrayList<Step> stepList) {
        mContext = context;
        mStepList = stepList;
    }

    @NonNull
    @Override
    public StepViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.steps_title_item, parent, false);
       final StepViewHolder stepViewHolder = new StepViewHolder(view);
       stepViewHolder.mStepTv.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent intent = new Intent(mContext, StepDetailActivity.class);
               intent.putParcelableArrayListExtra("step_list", mStepList);
               intent.putExtra("stepID", mStepList.get(stepViewHolder.getAdapterPosition()).getmStepId());
               intent.putExtra("description", mStepList.get(stepViewHolder.getAdapterPosition()).getmStepDescription());
               intent.putExtra("videoURL", mStepList.get(stepViewHolder.getAdapterPosition()).getmStepVideoUrl());
               mContext.startActivity(intent);
           }
       });

        return stepViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StepViewHolder holder, int position) {

        Step currentStep = mStepList.get(position);
            String shortDescription = currentStep.getmStepShortDescription();
            holder.mStepTv.setText(shortDescription);
        //}
    }

    @Override
    public int getItemCount() {
        return mStepList.size();
    }

    public class StepViewHolder extends RecyclerView.ViewHolder{

        public TextView mStepTv;

        public StepViewHolder(View itemView) {
            super(itemView);
            mStepTv = itemView.findViewById(R.id.step_tile_item_tv);




        }
    }

}
