package com.example.android.bakingapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Step implements Parcelable {

        @SerializedName("id")
        private int mRecipeId;
        @SerializedName("id")
        private int mStepId;
        @SerializedName("shortDescription")
        private String mStepShortDescription;
        @SerializedName("description")
        private String mStepDescription;
        @SerializedName("videoURL")
        private String mStepVideoUrl;

        /*public Step(int id, String shortDescription, String description, String videoUrl){
            mStepId = id;
            mStepShortDescription = shortDescription;
            mStepDescription = description;
            mStepVideoUrl = videoUrl;
        }*/

    public int getmRecipeId() {
        return mRecipeId;
    }

    public void setmRecipeId(int mRecipeId) {
        this.mRecipeId = mRecipeId;
    }

    public int getmStepId() {
        return mStepId;
    }

    public void setmStepId(int mStepId) {
        this.mStepId = mStepId;
    }

    public String getmStepShortDescription() {
        return mStepShortDescription;
    }

    public void setmStepShortDescription(String mStepShortDescription) {
        this.mStepShortDescription = mStepShortDescription;
    }

    public String getmStepDescription() {
        return mStepDescription;
    }

    public void setmStepDescription(String mStepDescription) {
        this.mStepDescription = mStepDescription;
    }

    public String getmStepVideoUrl() {
        return mStepVideoUrl;
    }

    public void setmStepVideoUrl(String mStepVideoUrl) {
        this.mStepVideoUrl = mStepVideoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mRecipeId);
        dest.writeInt(this.mStepId);
        dest.writeString(this.mStepShortDescription);
        dest.writeString(this.mStepDescription);
        dest.writeString(this.mStepVideoUrl);
    }

    public Step() {
    }

    protected Step(Parcel in) {
        this.mRecipeId = in.readInt();
        this.mStepId = in.readInt();
        this.mStepShortDescription = in.readString();
        this.mStepDescription = in.readString();
        this.mStepVideoUrl = in.readString();
    }

    public static final Parcelable.Creator<Step> CREATOR = new Parcelable.Creator<Step>() {
        @Override
        public Step createFromParcel(Parcel source) {
            return new Step(source);
        }

        @Override
        public Step[] newArray(int size) {
            return new Step[size];
        }
    };
}
