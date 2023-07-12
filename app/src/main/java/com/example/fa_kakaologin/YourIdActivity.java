package com.example.fa_kakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivityYourIdBinding;

public class YourIdActivity extends AppCompatActivity {

    ActivityYourIdBinding binding;
    TextView loginBtn, findPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityYourIdBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        loginBtn = binding.loginBtn;
        findPw = binding.findPassword;

        // 로그인하기 버튼
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 창으로 이동
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // 비밀번호찾기 텍스트
        findPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 비어있음
            }
        });
    }
}