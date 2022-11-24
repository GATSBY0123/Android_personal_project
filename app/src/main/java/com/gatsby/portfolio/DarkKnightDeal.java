package com.gatsby.portfolio;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DarkKnightDeal extends AppCompatActivity {

    ImageView ivHeroDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darkknightdeal);

        ivHeroDeal = (ImageView) findViewById(R.id.ivHeroDeal);

        Glide.with(DarkKnightDeal.this).load(R.drawable.darkknightdeal).into(ivHeroDeal);

    }
}
