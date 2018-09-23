package com.tarun.pickmedia;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tarun.pickmedia.databinding.ActivityShowImageGalleryBinding;

public class ShowImageGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityShowImageGalleryBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_show_image_gallery);
        ImageProvider.getInstance(this).getImages();
    }
}
