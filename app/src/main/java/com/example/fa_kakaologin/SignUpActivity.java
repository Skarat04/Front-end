package com.example.fa_kakaologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fa_kakaologin.databinding.ActivitySignUpBinding;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding binding;
    private ImageView kakaoSignUp, signUp;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 바인딩
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        kakaoSignUp = binding.signUpKakao;
        signUp = binding.signUp;
        login = binding.toLogin;

        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                updateKakaoLoginUi();
                return null;
            }
        };

        // 카카오 회원가입 버튼
        kakaoSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // 카카오톡 앱이 설치되어 있는 지 확인
//                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(SignUpActivity.this)) {
//                    UserApiClient.getInstance().loginWithKakaoTalk(SignUpActivity.this, callback);
//                } else { // 카카오톡 앱이 설치되어 있지 않을 경우
//                    UserApiClient.getInstance().loginWithKakaoAccount(SignUpActivity.this, callback);
//                }
                UserApiClient.getInstance().loginWithKakaoAccount(SignUpActivity.this, callback);
            }
        });

        // 계정 회원가입 버튼
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 회원 정보 입력 창으로 이동
                Intent intent = new Intent(getApplicationContext(), SignUpInfoActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 하기
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 로그인 창으로 이동
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateKakaoLoginUi() {
        UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
            @Override
            public Unit invoke(User user, Throwable throwable) {
                // 로그인 여부 확인
                if (user != null) {
                    Log.d("LOGIN", "카카오톡 로그인 상태");
                } else {
                    Log.d("LOGIN", "미로그인 상태");
                }
                return null;
            }
        });
    }

}