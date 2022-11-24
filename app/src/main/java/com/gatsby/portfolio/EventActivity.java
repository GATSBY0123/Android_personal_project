package com.gatsby.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        findViewById(R.id.ivEvent1).setOnClickListener(mClick);
        findViewById(R.id.ivEvent2).setOnClickListener(mClick);
        findViewById(R.id.ivEvent3).setOnClickListener(mClick);
    }
    View.OnClickListener mClick = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ivEvent1:
                    Intent act = new Intent(EventActivity.this, Event1WebViewActivity.class);
                    startActivity(act);
                    break;
                case R.id.ivEvent2:
                    Intent act2 = new Intent(EventActivity.this, Event2WebViewActivity.class);
                    startActivity(act2);
                    break;
                case R.id.ivEvent3:
                    Intent act3 = new Intent(EventActivity.this, Event3WebViewActivity.class);
                    startActivity(act3);
                    break;
            }
        }
    };
}