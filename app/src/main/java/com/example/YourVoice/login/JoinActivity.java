package com.example.YourVoice.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.YourVoice.R;

public class JoinActivity extends AppCompatActivity {
    private EditText join_id, join_password, join_name, join_pwck,join_phone_num,join_rrn,numcheck;
    private Button join_button, check_button,btn_change,join_read;
    private AlertDialog dialog;
    private boolean validate = false;
    private CheckBox ch;
    private static String userName,userId,userpw,userphonnum;
    //AppCompatActivity : 이전 Android 장치에서 일부 최신 플랫폼 기능을 사용하려는 작업의 기본 클래스
    //dialog: 전체 화면을 다 채우지 않고 일부 화면만 가리는 윈도우 사용자가 예/아니오 같은 선택을 하거나 추가적인 정보 입력을 하기를 기다립니다@SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        join_id = (EditText)findViewById(R.id.join_id);
        join_password = (EditText)findViewById(R.id.join_password);
        join_name = (EditText)findViewById(R.id.join_name);
        join_pwck = findViewById(R.id.join_pwck);
        join_phone_num = (EditText)findViewById(R.id.join_number);
        join_rrn = findViewById(R.id.rrn);
        join_read = findViewById(R.id.terms_of_use);
        check_button = findViewById(R.id.check_button);
        numcheck = findViewById(R.id.join_numbercheck);
        ch = findViewById(R.id.checkBox1);
        join_button = findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId = join_id.getText().toString();
                userName = join_name.getText().toString();
                userpw = join_password.getText().toString();
                userphonnum = join_phone_num.getText().toString();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        //btn_change.setOnClickListener(new OnClicnkListener{
        //   String text = edittext.getText().toString;

        //    DB에 저장하는 함수(text);
    };
    public void OnClickHandler(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("이용약관").setMessage("개인정보 수집 동의할꺼지?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();

        alertDialog.show();
    }






    //*************
}

//아이디값 찾아주기
    /*join_id = findViewById(R.id.join_id);
    join_password = findViewById( R.id.join_password );
    join_name = findViewById( R.id.join_name );
    join_pwck = findViewById(R.id.join_pwck);
    join_button=findViewById(R.id.join_button);
    join_phone_num=findViewById(R.id.join_number);
    join_rrn=findViewById(R.id.rrn);
    join_read=findViewById(R.id.terms_of_use);
    check_button=findViewById(R.id.check_button);
    numcheck=findViewById(R.id.join_numbercheck);
    ch=findViewById(R.id.checkBox1);
        //아이디 중복 체크
        check_button = findViewById(R.id.check_button);
        check_button.setOnClickListener(new View.OnClickListener() {
            // 아이디값 찾기?? 왜 하쥐..?
            @Override
            public void onClick(View view) {
                String UserId = join_id.getText().toString();
                if (validate) {
                    return; //검증 완료
                }
                //아이디를 기입 안 했을 경우
                if (UserId.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("아이디를 입력하세요.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                                dialog.show();
                                join_id.setEnabled(false); //아이디값 고정
                                validate = true; //검증 완료
                                //check_button.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("이미 존재하는 아이디입니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace(); //에러의 발생근원지를 찾아서 단계별로 에러를 출력
                        }
                    }
                };
                ValidateRequest validateRequest = new ValidateRequest(UserId, responseListener);
                RequestQueue queue = Volley.newRequestQueue(JoinActivity.this);
                queue.add(validateRequest);
            }
        });

        //회원가입 버튼 클릭 시 수행
        join_button = findViewById( R.id.join_button );
        join_button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UserId = join_id.getText().toString();
                final String UserPwd = join_password.getText().toString();
                final String UserName = join_name.getText().toString();
                final String PassCk = join_pwck.getText().toString();


                //아이디 중복체크 했는지 확인
                if (!validate) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("중복된 아이디가 있는지 확인하세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                //한 칸이라도 입력 안했을 경우
                if (UserId.equals("") || UserPwd.equals("") || UserName.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                    dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            //회원가입 성공시
                            if(UserPwd.equals(PassCk)) {
                                if (success) {

                                    Toast.makeText(getApplicationContext(), String.format("%s님 가입을 환영합니다.", UserName), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(JoinActivity.this, JoinActivity.class);
                                    startActivity(intent);

                                    //회원가입 실패시
                                } else {
                                    Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
                                dialog = builder.setMessage("비밀번호가 동일하지 않습니다.").setNegativeButton("확인", null).create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청
                //RegisterRequest registerRequest = new RegisterRequest( UserId, UserPwd, UserName, responseListener);
                //RequestQueue queue = Volley.newRequestQueue( JoinActivity.this );
                //queue.add( registerRequest );
            }

        });
    }*/


