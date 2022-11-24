package com.gatsby.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeroLayoutActivity extends AppCompatActivity {

    TextView tvCore, tvDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_layout);

        tvCore = findViewById(R.id.tvCore);
        tvDeal = findViewById(R.id.tvDeal);

        tvCore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(HeroLayoutActivity.this, WarriorCore.class);
                startActivity(act);
                finish();
            }
        });
        tvDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(HeroLayoutActivity.this, HeroDeal.class);
                startActivity(act2);
                finish();
            }
        });
    }
}
