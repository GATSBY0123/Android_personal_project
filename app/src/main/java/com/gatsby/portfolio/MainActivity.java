package com.gatsby.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnJob).setOnClickListener(mClick);
        findViewById(R.id.btn_event).setOnClickListener(mClick);
        findViewById(R.id.btn_hunt).setOnClickListener(mClick);
        findViewById(R.id.btn_meso).setOnClickListener(mClick);

    }
    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnJob:
                    Intent act = new Intent(MainActivity.this, JobActivity.class);
                    startActivity(act);
                    break;
                case R.id.btn_event:
                    Intent act3 = new Intent(MainActivity.this, EventActivity.class);
                    startActivity(act3);
                    break;
                case R.id.btn_hunt:
                    Intent act2 = new Intent(MainActivity.this, HuntActivity.class);
                    startActivity(act2);
                    break;
                case R.id.btn_meso:
                    Intent act4 = new Intent(MainActivity.this, MesoActivity.class);
                    startActivity(act4);
                    break;
            }
        }
    };
}
