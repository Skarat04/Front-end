package com.example.fa_kakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivityFindIdBinding;

public class FindIdActivity extends AppCompatActivity {

    ActivityFindIdBinding binding;
    TextView findIdBtn, findPw, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityFindIdBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        findIdBtn = binding.findIdBtn;
        findPw = binding.findPassword;
        login = binding.toLogin;

        // 아이디 찾기 버튼
        findIdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 닉네임, 비밀번호 입력
                // + 입력된 정보에 맞는 회원이 있다고 가정

                // 아이디 확인 창으로 이동
                Intent intent = new Intent(getApplicationContext(), YourIdActivity.class);
                startActivity(intent);
            }
        });

        // 비밀번호 찾기 텍스트
        findPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 비어있음
            }
        });

        // 로그인하기 텍스트
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 창으로 이동
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}