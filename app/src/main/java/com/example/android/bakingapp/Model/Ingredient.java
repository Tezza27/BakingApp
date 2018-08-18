package com.example.android.bakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Ingredient implements Parcelable {
    @SerializedName("id")
    private int mRecipeId;
    @SerializedName("ingredient")
    private String mIngredientIngredient;
    @SerializedName("quantity")
    private double mIngredientQuantity;
    @SerializedName("measure")
    private String mIngredientMeasure;

    /*public Ingredient(String ingredient, double quantity, String measure){
        mIngredientIngredient = ingredient;
        mIngredientQuantity = quantity;
        mIngredientMeasure = measure;
    }*/

    public int getmRecipeId() {
        return mRecipeId;
    }

    public void setmRecipeId(int mRecipeId) {
        this.mRecipeId = mRecipeId;
    }

    public String getmIngredientIngredient() {
        return mIngredientIngredient;
    }

    public void setmIngredientIngredient(String mIngredientIngredient) {
        this.mIngredientIngredient = mIngredientIngredient;
    }

    public double getmIngredientQuantity() {
        return mIngredientQuantity;
    }

    public void setmIngredientQuantity(double mIngredientQuantity) {
        this.mIngredientQuantity = mIngredientQuantity;
    }

    public String getmIngredientMeasure() {
        return mIngredientMeasure;
    }

    public void setmIngredientMeasure(String mIngredientMeasure) {
        this.mIngredientMeasure = mIngredientMeasure;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRecipeId);
        dest.writeString(this.mIngredientIngredient);
        dest.writeDouble(this.mIngredientQuantity);
        dest.writeString(this.mIngredientMeasure);
    }

    public Ingredient() {
    }

    protected Ingredient(Parcel in) {
        this.mRecipeId = in.readInt();
        this.mIngredientIngredient = in.readString();
        this.mIngredientQuantity = in.readDouble();
        this.mIngredientMeasure = in.readString();
    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
