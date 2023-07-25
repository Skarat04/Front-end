package com.example.fa_kakaologin;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivityExistsAccountBinding;

public class ExistsAccountActivity extends AppCompatActivity {

    ActivityExistsAccountBinding binding;
    TextView loginBtn, signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityExistsAccountBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        loginBtn = binding.loginBtn;
        signUpBtn = binding.signUpBtn;

        // 로그인 버튼
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 창으로 이동
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        // 회원가입 버튼
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 창으로 이동
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}