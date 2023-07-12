package com.example.fa_kakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivityLoginBinding;
import com.example.fa_kakaologin.databinding.ActivitySignUpBinding;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    TextView errorId, errorPw, loginBtn, findId, findPw, signUp;
    ImageView loginKakao, loginKeeping;

    public String id = "", pw = "";
    public Boolean loginKeep = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 바인딩
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        errorId = binding.errorWrongId;
        errorPw = binding.errorWrongPassword;
        loginBtn = binding.loginBtn;
        findId = binding.findId;
        findPw = binding.findPassword;
        signUp = binding.toSignUp;
        loginKakao = binding.loginKakao;
        loginKeeping = binding.loginKeeping;

        errorId.setVisibility(View.GONE);
        errorPw.setVisibility(View.GONE);

        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                return null;
            }
        };

        // login 버튼
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = binding.idEdit.getText().toString();
                pw = binding.passwordEdit.getText().toString();

                if(id.length() != 0) {
                    if(pw.length() != 0) {
                        // 아이디와 비밀번호 모두 올바르게 입력
                        // + 입력한 정보가 중복된 계정이라고 가정

                        // 이미 존재하는 계정 알림 창으로 이동
                        Intent intent = new Intent(getApplicationContext(), ExistsAccountActivity.class);
                        startActivity(intent);
                    } else {
                        // 비밀번호 미입력
                        // + 비밀번호가 틀렸다고 가정
                        errorId.setVisibility(View.GONE);
                        errorPw.setVisibility(View.VISIBLE);
                    }
                } else {
                    // 아이디 미입력
                    // + 없는 아이디라고 가정
                    errorId.setVisibility(View.VISIBLE);
                    errorPw.setVisibility(View.GONE);
                }
            }
        });

        // 로그인 유지 토글
        loginKeeping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginKeep = !loginKeep;

                if (loginKeep) {
                    loginKeeping.setImageResource(R.drawable.checked);
                } else {
                    loginKeeping.setImageResource(R.drawable.unchecked);
                }
            }
        });

        // 카카오 회원가입 버튼
        loginKakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카카오톡 앱이 설치되어 있는 지 확인
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
                } else { // 카카오톡 앱이 설치되어 있지 않을 경우
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
                }
            }
        });

        // 아이디 찾기 텍스트
        findId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아이디 찾기 창으로 이동
                Intent intent = new Intent(getApplicationContext(), FindIdActivity.class);
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

        // 회원가입 텍스트
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원가입 창으로 이동
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}