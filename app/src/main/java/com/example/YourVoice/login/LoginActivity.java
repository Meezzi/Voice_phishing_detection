package com.example.YourVoice.login;

import androidx.appcompat.app.AppCompatActivity;

import com.example.YourVoice.MainActivity;
import com.example.YourVoice.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        join_button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString();
                String pwck = login_password.getText().toString();
                Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. try 돌리기 전", Toast.LENGTH_SHORT).show();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (1)", Toast.LENGTH_SHORT).show();
                            JSONObject jsonResponse = new JSONObject(response);
                            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (2)", Toast.LENGTH_SHORT).show();
                            boolean success = jsonResponse.getBoolean("success");
                            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. (3)", Toast.LENGTH_SHORT).show();

                            if (success) {
                                Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();

                                String db_email = jsonResponse.getString("email");
                                String db_pwck = jsonResponse.getString("pwck");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                // 로그인 하면서 사용자 정보 넘기기
                                intent.putExtra("email", email);
                                intent.putExtra("pwck", pwck);
                                startActivity(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "로그인에 실패했습니다. 예외처리", Toast.LENGTH_SHORT).show();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(email, pwck, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }
        });
    }

}