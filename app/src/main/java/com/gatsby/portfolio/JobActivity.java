package com.gatsby.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class JobActivity extends AppCompatActivity {

    //BottomNavigationView 선언
    BottomNavigationView bottomNavigationView;
    //Fragment 선언
    Frag1 frag1;
    Frag2 frag2;
    Frag3 frag3;
    Frag4 frag4;
    Frag5 frag5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);


        //초기 세팅
        init();


        //bottomNavigation의 아이콘을 선택했을 때 원하는 프레그먼트가 띄어질 수 있도록 리스너를 추가한다.
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_warrior: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_frame, new Frag1())
                                .commit();
                        return true;
                    }
                    case R.id.action_archor: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_frame, new Frag2())
                                .commit();
                        return true;
                    }
                    case R.id.action_magican: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_frame, new Frag3())
                                .commit();
                        return true;
                    }
                    case R.id.action_theif: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_frame, new Frag4())
                                .commit();
                        return true;
                    }
                    case R.id.action_pirate: {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_frame, new Frag5())
                                .commit();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void init(){
        //fragment 객체 생성
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();

        //main.xml상의 bottomNavigationView 연결
        bottomNavigationView = findViewById(R.id.bottomNavi);

        //제일 처음 띄어줄 뷰 세팅
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame,frag1).commitAllowingStateLoss();

    }
}