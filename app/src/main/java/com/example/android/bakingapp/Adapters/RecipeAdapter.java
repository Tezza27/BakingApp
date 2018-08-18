package com.example.android.bakingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.bakingapp.Activities.DetailListActivity;
import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.Model.RecipeClass;
import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>{

    private Context mContext;
    private List<RecipeClass> mData;
    private ArrayList<Step> stepList;
    private ArrayList<Ingredient> ingredientList;

    public RecipeAdapter(Context mContext, List<RecipeClass> mData, List<Step> stepList, List<Ingredient> ingredientList) {
        this.mContext = mContext;
        this.mData = mData;
        this.stepList = new ArrayList<Step>(stepList);
        this.ingredientList = new ArrayList<Ingredient>(ingredientList);
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.recipe_title_item, parent, false);
        final RecipeViewHolder recipeViewHolder = new RecipeViewHolder(view);
        recipeViewHolder.lv_recipe_title.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(mContext, DetailListActivity.class);
                intent.putExtra("recipe_id", mData.get(recipeViewHolder.getAdapterPosition()).getmRecipeId());
                intent.putParcelableArrayListExtra("step_list", stepList);
                intent.putParcelableArrayListExtra("ingredient_list", ingredientList);
                mContext.startActivity(intent);

            }

            });

        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getmRecipeName());
        holder.tv_servings.setText(String.valueOf(mData.get(position).getmRecipeServings()));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_servings;
        LinearLayout lv_recipe_title;

        RecipeViewHolder(View itemView) {
            super(itemView);
            tv_name=itemView.findViewById(R.id.recipe_button_name_TV);
            tv_servings = itemView.findViewById(R.id.recipe_button_servings_TV);
            lv_recipe_title = itemView.findViewById(R.id.recipe_button_LV);
        }
    }
}
