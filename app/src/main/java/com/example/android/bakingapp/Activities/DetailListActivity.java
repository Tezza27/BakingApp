package com.example.android.bakingapp.Activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.android.bakingapp.Adapters.IngredientAdapter;
import com.example.android.bakingapp.Adapters.StepAdapter;


import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;

import java.util.ArrayList;

public class DetailListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView stepRecyclerView;
    private RecyclerView ingredientRecyclerView;
    private StepAdapter stepAdapter;
    private IngredientAdapter ingredientAdapter;
    private ArrayList<Step> stepArrayList;
    private ArrayList<Step> filteredStepArrayList;
    private ArrayList<Ingredient> ingredientArrayList;
    private ArrayList<Ingredient> filteredIngredientArrayList;
    int recipeRecipeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_master);
        stepArrayList=getIntent().getExtras().getParcelableArrayList("step_list");
        ingredientArrayList=getIntent().getExtras().getParcelableArrayList("ingredient_list");
        recipeRecipeId = getIntent().getExtras().getInt("recipe_id");

        stepRecyclerView=findViewById(R.id.steps_rv);
        stepRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        stepRecyclerView.setLayoutManager(linearLayoutManager);

        filterStepArrayList(stepArrayList);
        filterIngredientArrayList(ingredientArrayList);
        Button ingredientsButton = findViewById(R.id.ingredients_button);
        ingredientsButton.setOnClickListener(this);

        stepAdapter = new StepAdapter(DetailListActivity.this, filteredStepArrayList);
        stepRecyclerView.setAdapter(stepAdapter);

    }

    private ArrayList<Step> filterStepArrayList(ArrayList<Step> stepArrayList){
        filteredStepArrayList = new ArrayList<Step>();
        for (Step currentStep: stepArrayList) {
            if (currentStep.getmRecipeId() == recipeRecipeId) {
                filteredStepArrayList.add(currentStep);
            }
        }

        return filteredStepArrayList;
    }

    private ArrayList<Ingredient> filterIngredientArrayList(ArrayList<Ingredient> ingredientArrayList){
        filteredIngredientArrayList = new ArrayList<Ingredient>();
        for (Ingredient currentIngredient: ingredientArrayList) {
            if (currentIngredient.getmRecipeId() == recipeRecipeId) {
                filteredIngredientArrayList.add(currentIngredient);
            }
        }

        return filteredIngredientArrayList;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(DetailListActivity.this, IngredientsListActivity.class);
        intent.putParcelableArrayListExtra("ingredient_list", filteredIngredientArrayList);
        DetailListActivity.this.startActivity(intent);
        }
}
