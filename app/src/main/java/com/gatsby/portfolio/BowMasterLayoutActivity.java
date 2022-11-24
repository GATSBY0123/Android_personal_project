package com.gatsby.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BowMasterLayoutActivity extends AppCompatActivity {

    TextView tvCore, tvDeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bowmaster_layout);

        tvCore = findViewById(R.id.tvCore);
        tvDeal = findViewById(R.id.tvDeal);

        tvCore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act = new Intent(BowMasterLayoutActivity.this, WarriorCore.class);
                startActivity(act);
                finish();
            }
        });
        tvDeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent act2 = new Intent(BowMasterLayoutActivity.this, HeroDeal.class);
                startActivity(act2);
                finish();
            }
        });
    }
}
