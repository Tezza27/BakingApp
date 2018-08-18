package com.example.android.bakingapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.bakingapp.Adapters.RecipeAdapter;
import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.Model.RecipeClass;
import com.example.android.bakingapp.Model.Step;
import com.example.android.bakingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private JsonRequest request;
    private TextView recipeName;
    private final String BAKING_DATA_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

    private List<RecipeClass> recipeClassList = new ArrayList<>();
    private List<Ingredient> ingredientList =  new ArrayList<>();
    private List<Step> stepList = new ArrayList<>();

    private RecipeAdapter recipeAdapter;
    private RecyclerView recipeRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeRecyclerView = findViewById(R.id.recipe_names_RV);

        jsonParse();
    }

    private void jsonParse() {

        request = new JsonArrayRequest(BAKING_DATA_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject recipeJsonObject = null;
                for (int i = 0 ; i<response.length();i++) {
                try {

                    recipeJsonObject = response.getJSONObject(i);

                    RecipeClass recipeObject = new RecipeClass();

                    recipeObject.setmRecipeId(recipeJsonObject.getInt("id"));
                    recipeObject.setmRecipeName(recipeJsonObject.getString("name"));
                    recipeObject.setmRecipeServings(recipeJsonObject.getInt("servings"));

                    JSONArray ingredientJsonArray = recipeJsonObject.getJSONArray("ingredients");
                    for (int j = 0 ; j<ingredientJsonArray.length();j++) {
                        JSONObject ingredientJsonObject = ingredientJsonArray.getJSONObject(j);
                        Ingredient ingredientObject = new Ingredient();
                        ingredientObject.setmRecipeId(recipeJsonObject.getInt("id"));
                        ingredientObject.setmIngredientQuantity(ingredientJsonObject.getDouble("quantity"));
                        ingredientObject.setmIngredientMeasure(ingredientJsonObject.getString("measure"));
                        ingredientObject.setmIngredientIngredient(ingredientJsonObject.getString("ingredient"));
                        ingredientList.add(ingredientObject);
                    }

                    JSONArray stepJsonArray = recipeJsonObject.getJSONArray("steps");
                    for (int k = 0 ; k<stepJsonArray.length();k++) {
                        JSONObject stepJsonObject = stepJsonArray.getJSONObject(k);
                        Step stepObject = new Step();
                        stepObject.setmRecipeId(recipeJsonObject.getInt("id"));
                        stepObject.setmStepId(stepJsonObject.getInt("id"));
                        stepObject.setmStepShortDescription(stepJsonObject.getString("shortDescription"));
                        stepObject.setmStepDescription(stepJsonObject.getString("description"));
                        if (stepJsonObject.getString("videoURL").isEmpty()) {
                            stepObject.setmStepVideoUrl(stepJsonObject.getString("thumbnailURL"));
                        }else{
                            stepObject.setmStepVideoUrl(stepJsonObject.getString("videoURL"));
                        }
                        stepList.add(stepObject);
                    }

                    recipeClassList.add(recipeObject);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
                recipeRecyclerView.setHasFixedSize(true);
                recipeAdapter = new RecipeAdapter(MainActivity.this, recipeClassList, stepList, ingredientList);
                recipeRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recipeRecyclerView.setAdapter(recipeAdapter);

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }


}
