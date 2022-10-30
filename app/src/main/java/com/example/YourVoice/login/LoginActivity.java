package com.example.YourVoice.login;

import androidx.appcompat.app.AppCompatActivity;

import com.example.YourVoice.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText login_email, login_password;
    private Button login_button, join_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);


        join_button=findViewById(R.id.join_button);
        login_button=findViewById(R.id.login_button);

        login_button.setOnClickListener(view -> {
            String user_email = login_email.getText().toString();
            String user_pw = login_password.getText().toString();
            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. try 돌리기 전", Toast.LENGTH_SHORT).show();
            Response.Listener<String> responseListener = response -> {
                try{
                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (1)", Toast.LENGTH_SHORT).show();
                    JSONObject jsonResponse = new JSONObject(response);
                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (2)", Toast.LENGTH_SHORT).show();
                    boolean success = jsonResponse.getBoolean("success");
                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (3)", Toast.LENGTH_SHORT).show();
                    if(success){
                        Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();

                        String email = jsonResponse.getString("email");
                        String password = jsonResponse.getString("password");
                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                        // 로그인 하면서 사용자 정보 넘기기
                        intent.putExtra("user_email", user_email);
                        intent.putExtra("user_pw", user_pw);
                        startActivity(intent);

                    } else {
                        Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch(Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. 예외처리", Toast.LENGTH_SHORT).show();
                }
            };

            LoginRequest loginRequest = new LoginRequest(user_email, user_pw, responseListener);
            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
            queue.add(loginRequest);

        });

        // 회원가입 버튼 클릭
        join_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });


//        login_button.setOnClickListener(view -> {
//            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//            startActivity(intent);
//        });
    }
}

