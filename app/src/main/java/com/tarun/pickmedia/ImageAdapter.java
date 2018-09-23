package com.tarun.pickmedia;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageAdapterHolder>{
    private String[] mImages;

    @NonNull
    @Override
    public ImageAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapterHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    public static class ImageAdapterHolder extends RecyclerView.ViewHolder {
        public ImageAdapterHolder(View itemView) {
            super(itemView);
        }
    }

    public ImageAdapter(String[] images) {
        mImages = images;
    }
}
