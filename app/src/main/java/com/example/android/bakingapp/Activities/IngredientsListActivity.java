package com.example.android.bakingapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.bakingapp.Adapters.IngredientAdapter;
import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.R;

import java.util.ArrayList;

public class IngredientsListActivity extends AppCompatActivity {

    private RecyclerView ingredientRecyclerView;
    private IngredientAdapter ingredientAdapter;
    private ArrayList<Ingredient> ingredientArrayList;
    int recipeRecipeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredients_list);

        ingredientRecyclerView=findViewById(R.id.ingredients_rv);
        ingredientRecyclerView.setHasFixedSize(true);

        ingredientArrayList=getIntent().getExtras().getParcelableArrayList("ingredient_list");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ingredientRecyclerView.setLayoutManager(linearLayoutManager);
        ingredientAdapter = new IngredientAdapter(this, ingredientArrayList);
        ingredientRecyclerView.setAdapter(ingredientAdapter);
    }
}
