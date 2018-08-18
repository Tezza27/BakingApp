package com.example.android.bakingapp.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.bakingapp.Model.Ingredient;
import com.example.android.bakingapp.R;

import java.util.List;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>{

    private Context mContext;
    private List<Ingredient> mIngredientsList;
    String stringQty;

    public IngredientAdapter(Context mContext, List<Ingredient> filteredIngredientArrayList) {
        this.mContext = mContext;
        this.mIngredientsList = filteredIngredientArrayList;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.ingredient_item, parent, false);
        IngredientViewHolder viewHolder = new IngredientViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {

        double currentQty = mIngredientsList.get(position).getmIngredientQuantity();
        stringQty = formatDouble(currentQty);
        String currentMeasure= mIngredientsList.get(position).getmIngredientMeasure();
        String combinedQty = stringQty + " " + currentMeasure;
        holder.ingredientQtyTv.setText(combinedQty);
        holder.ingredientDescriptionTv.setText(mIngredientsList.get(position).getmIngredientIngredient());

    }

    @Override
    public int getItemCount() {
        return mIngredientsList.size();
    }

    public static class IngredientViewHolder extends RecyclerView.ViewHolder{
        TextView ingredientQtyTv;
        TextView ingredientDescriptionTv;
        LinearLayout ingredientLayoutLV;


        public IngredientViewHolder(View itemView){
            super(itemView);

            ingredientQtyTv = itemView.findViewById(R.id.ingredient_item_qty_tv);
            ingredientDescriptionTv = itemView.findViewById(R.id.ingredient_item_description_tv);
            ingredientLayoutLV = itemView.findViewById(R.id.ingredient_item_layout);

        }
    }

    public String formatDouble(double d) {
        if (d == Math.floor(d)) {
            stringQty = String.valueOf(d).substring(0,String.valueOf(d).indexOf("."));
        } else {
            stringQty = String.valueOf(d);
        }
        return stringQty;
    }

}
