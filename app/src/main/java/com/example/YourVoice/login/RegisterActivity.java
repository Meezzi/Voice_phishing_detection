package com.example.YourVoice.login;

import com.example.YourVoice.R;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText idText,join_email,join_pwck,join_name,join_area, join_age, join_phone;
    private Button join_login, join_button;
    private AlertDialog dialog;
    private boolean validate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        join_email = (EditText) findViewById(R.id.join_email);
        join_pwck = (EditText) findViewById(R.id.join_pwck);
        join_name = (EditText) findViewById(R.id.join_name);
        join_area = (EditText) findViewById(R.id.join_area);
        join_age = (EditText) findViewById(R.id.join_age);
        join_phone = (EditText) findViewById(R.id.join_phone);


        join_login = (Button) findViewById(R.id.join_login);
        join_button = (Button) findViewById(R.id.join_button);

        join_login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String email = join_email.getText().toString();
                String pwck = join_pwck.getText().toString();
                String name = join_name.getText().toString();
                String area = join_area.getText().toString();
                String age = join_age.getText().toString();
                String phone = join_phone.getText().toString();

                //한 칸이라도 입력 안했을 경우
                if (email.equals("") || pwck.equals("") || name.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean( "success" );

                            if(pwck.equals(pwck)) {
                                if (success) {

                                    Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", name), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);

                                    //회원가입 실패시
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest( email, pwck, name, area, age, phone, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }


}
