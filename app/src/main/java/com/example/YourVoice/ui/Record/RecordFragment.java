package com.example.YourVoice.ui.Record;

import com.example.YourVoice.R;

import static android.Manifest.permission.INTERNET;
import static android.Manifest.permission.RECORD_AUDIO;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class RecordFragment extends Fragment {

    View view;

    public TextView timer;
    public TextView phoneNum;
    public TextView stt;
    public TextView accuracy;
    public String phone;
    public long myBaseTime;
    public double setAccuracy;
    private boolean popUpOpen = false;
    SharedPreferences sharedPreferences;

    public String TAG = "CallActivity";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_record,null); //view를 불러온다.
        SetLayout(view);

        return view;
    }


    public void SetLayout(View view){

        view.findViewById(R.id.endCallBtn);
        view.findViewById(R.id.timer);
        view.findViewById(R.id.phoneNum);
        view.findViewById(R.id.speechToText);
        view.findViewById(R.id.accuracyText);
    }


    //현재시간을 계속 구해서 출력하는 메소드
    String getTimeOut(){
        long now = SystemClock.elapsedRealtime(); //애플리케이션이 실행되고나서 실제로 경과된 시간(??)^^;
        long outTime = now - myBaseTime;
        String easy_outTime = String.format("%02d:%02d", outTime/1000 / 60, (outTime/1000)%60);
        return easy_outTime;
    }



}