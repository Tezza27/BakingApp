package com.example.android.bakingapp.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RecipeClass implements Parcelable {
   @SerializedName("id")
   private int mRecipeId;
   @SerializedName("name")
   private String mRecipeName;
   @SerializedName("servings")
   private int mRecipeServings;
    @SerializedName("ingredients")
    private List<Ingredient> mIngredient;
    @SerializedName("steps")
    private List<Step> mStep;

    /*public RecipeClass(int id, String name, int servings, List<Ingredient> ingredient, List<Step> step){
        mRecipeId = id;
        mRecipeName = name;
        mRecipeServings = servings;
        mIngredient = ingredient;
        mStep = step;
    }*/

    public int getmRecipeId() {
        return mRecipeId;
    }

    public void setmRecipeId(int mRecipeId) {
        this.mRecipeId = mRecipeId;
    }

    public String getmRecipeName() {
        return mRecipeName;
    }

    public void setmRecipeName(String mRecipeName) {
        this.mRecipeName = mRecipeName;
    }

    public int getmRecipeServings() {
        return mRecipeServings;
    }

    public void setmRecipeServings(int mRecipeServings) {
        this.mRecipeServings = mRecipeServings;
    }

    public List<Ingredient> getmIngredient() {
        return mIngredient;
    }

    public void setmIngredient(List<Ingredient> mIngredient) {
        this.mIngredient = mIngredient;
    }

    public List<Step> getmStep() {
        return mStep;
    }

    public void setmStep(List<Step> mStep) {
        this.mStep = mStep;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRecipeId);
        dest.writeString(this.mRecipeName);
        dest.writeInt(this.mRecipeServings);
        dest.writeList(this.mIngredient);
        dest.writeList(this.mStep);
    }

    public RecipeClass() {
    }

    protected RecipeClass(Parcel in) {
        this.mRecipeId = in.readInt();
        this.mRecipeName = in.readString();
        this.mRecipeServings = in.readInt();
        this.mIngredient = new ArrayList<Ingredient>();
        in.readList(this.mIngredient, Ingredient.class.getClassLoader());
        this.mStep = new ArrayList<Step>();
        in.readList(this.mStep, Step.class.getClassLoader());
    }

    public static final Parcelable.Creator<RecipeClass> CREATOR = new Parcelable.Creator<RecipeClass>() {
        @Override
        public RecipeClass createFromParcel(Parcel source) {
            return new RecipeClass(source);
        }

        @Override
        public RecipeClass[] newArray(int size) {
            return new RecipeClass[size];
        }
    };
}
