package com.gatsby.portfolio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences pref;          // 프리퍼런스
    SharedPreferences.Editor editor; // 에디터

    String myStr;                   // 문자 변수
    CheckBox checkBox;

    EditText etId, etPassword;          // 레이아웃 변수 EditText

    String data, data2, data3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etId = findViewById(R.id.etId);
        etPassword = findViewById(R.id.etPassword);
        findViewById(R.id.btnLogin).setOnClickListener(mClick);
        findViewById(R.id.btnJoin).setOnClickListener(mClick);

        // 1. Shared Preference 초기화
        pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        editor = pref.edit();

        // 2. 저장해둔 값 불러오기 ("식별값", 초기값) -> 식별값과 초기값은 직접 원하는 이름과 값으로 작성.
        myStr = pref.getString("MyStr", "");   // String 불러오기 (저장해둔 값 없으면 초기값으로 불러옴)

        // 3. 레이아웃 변수 초기화
        etId = findViewById(R.id.etId);

        // 4. 앱을 새로 켜면 이전에 저장해둔 값이 표시됨
        etId.setText(myStr);


        // 5. 각 버튼 클릭시 새로운 값 저장
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()) {
                    myStr = etId.getText().toString();
                    editor.putString("MyStr", myStr);
                    editor.apply(); // 저장
                }
            }
        });
    }
        View.OnClickListener mClick = new View.OnClickListener() {
            public void onClick(View v) {
                String userID = etId.getText().toString();
                String userPassword = etPassword.getText().toString();
                switch (v.getId()) {
                    case R.id.btnJoin:
                        Intent login = new Intent(LoginActivity.this, JoinActivity.class);
                        startActivity(login);
                        break;
                    case R.id.btnLogin:
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    boolean success = jsonObject.getBoolean("success");
                                    if (success){ //로그인에 성공한 경우
                                        String userID = jsonObject.getString("userID");
                                        String userPassword = jsonObject.getString("userPassword");

                                        Toast.makeText(LoginActivity.this, "로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    } else { // 로그인에 실패한 경우
                                        Toast.makeText(LoginActivity.this, "로그인에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                        return;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        LoginRequest loginRequest = new LoginRequest(userID, userPassword, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                        queue.add(loginRequest);
                }
            }
        };
    }
