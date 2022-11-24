package com.gatsby.portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LogoActivity extends AppCompatActivity {
    private static int progress_percent;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        tv1 = (TextView)findViewById(R.id.tvLoad);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progress_percent = 0;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent = new Intent (LogoActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },5000); //5초 후 인트로 실행
        new Thread() {
            public  void run() {
                while(true) {
                    try {
                        while(!Thread.currentThread().isInterrupted()){
                            progress_percent += 10;
                            Thread.sleep(500);
                            ProgressBar progressBar = findViewById(R.id.progressBar);
                            progressBar.setProgress(progress_percent);

                            if (progress_percent >= 100) {
                                Intent intent = new Intent(LogoActivity.this, LoginActivity.class);
                                startActivity(intent);
                                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                currentThread().interrupt();
                            }
                        }
                    } catch (Throwable t){
                    } finally {
                    }
                }
            }
        }.start();
    }
}