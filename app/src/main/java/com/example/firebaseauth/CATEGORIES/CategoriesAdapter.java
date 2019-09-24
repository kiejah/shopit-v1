package com.example.firebaseauth.CATEGORIES;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.firebaseauth.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    private int[] categoryimages;
    public CategoriesAdapter(int[] catImages){
        this.categoryimages= catImages;
    }
    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_layout,viewGroup,false);
        CategoriesViewHolder categoriesViewholder= new CategoriesViewHolder(view);
        return categoriesViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder categoriesViewHolder, int position) {

        int image_id = categoryimages[position];
        categoriesViewHolder.cat_image.setImageResource(image_id);

    }


    @Override
    public int getItemCount() {
        return categoryimages.length;
    }
    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{
    ImageView cat_image;
        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            cat_image= itemView.findViewById(R.id.category_image);
        }
    }
}
