package com.example.android.bakingapp.JsonParsing;

/*public class JsonParse {

    public JsonParse(String response) {
        JSONObject jsonObject = null;
        for (int i = 0; i < response.length(); i++) {
            try {
                jsonObject = response.getJSONObject(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            RecipeClass recipeObject = new RecipeClass();
            try {
                recipeObject.setmRecipeId(jsonObject.getInt("id"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                recipeObject.setmRecipeName(jsonObject.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            try {
                recipeObject.setmRecipeServings(jsonObject.getInt("servings"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JSONArray ingredientJsonArray = null;
            try {
                ingredientJsonArray = jsonObject.getJSONArray("ingredients");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < ingredientJsonArray.length(); j++) {
                JSONObject ingredientJsonObject = null;
                try {
                    ingredientJsonObject = ingredientJsonArray.getJSONObject(j);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    ingredientJsonObject = ingredientJsonArray.getJSONObject(j);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Ingredient ingredientObject = new Ingredient();
                try {

                    ingredientObject.setmIngredientQuantity(ingredientJsonObject.getDouble("quantity"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    ingredientObject.setmIngredientMeasure(ingredientJsonObject.getString("measure"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    ingredientObject.setmIngredientIngredient(ingredientJsonObject.getString("ingredient"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            JSONArray stepJsonArray = null;
            try {
                stepJsonArray = jsonObject.getJSONArray("steps");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int k = 0; k < stepJsonArray.length(); k++) {
                JSONObject stepJsonObject = null;
                try {
                    stepJsonObject = stepJsonArray.getJSONObject(k);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    stepJsonObject = ingredientJsonArray.getJSONObject(k);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Step stepObject = new Step();
                try {

                    stepObject.setmStepId(stepJsonObject.getInt("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    stepObject.setmStepShortDescription(stepJsonObject.getString("shortDescription"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    stepObject.setmStepDescription(stepJsonObject.getString("description"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {

                    stepObject.setmStepVideoUrl(stepJsonObject.getString("videoURL"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            recipeClassList.add(recipeObject);

        }

        setRecyclerView(recipeClassList);
    }
}*/
