package com.example.fa_kakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivitySignUpInfoBinding;

public class SignUpInfoActivity extends AppCompatActivity {

    ActivitySignUpInfoBinding binding;
    TextView signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySignUpInfoBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        signUpBtn = binding.signUpBtn;

        // 회원가입 버튼
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 비어있음
            }
        });
    }


}