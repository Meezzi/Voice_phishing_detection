package com.example.YourVoice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import com.example.YourVoice.login.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        moveMain(1);
    }

    private void moveMain(int sec) {
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //new Intent(현재 context, 이동할 activity)
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(intent);	//intent 에 명시된 액티비티로 이동

                finish();	//현재 액티비티 종료
            }
        }, 2000 * sec); // sec초 정도 딜레이를 준 후 시작
    }

}
