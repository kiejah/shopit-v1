package com.example.firebaseauth;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AdsRecyclerAdapter extends RecyclerView.Adapter<AdsRecyclerAdapter.AdsImageViewHolder> {

    private int[] images;

    public AdsRecyclerAdapter(int[] images){
    this.images= images;
    }
    @NonNull
    @Override
    public AdsImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_ads,parent,false);
       AdsImageViewHolder adsImageViewHolder= new AdsImageViewHolder(view);
       return adsImageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdsImageViewHolder viewHolder, int position) {
        int image_id = images[position];
        viewHolder.advert_image.setImageResource(image_id);


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class AdsImageViewHolder extends RecyclerView.ViewHolder{
        ImageView advert_image;

        public AdsImageViewHolder(@NonNull View itemView) {
            super(itemView);
            advert_image= itemView.findViewById(R.id.advert_image);
        }
    }
}
