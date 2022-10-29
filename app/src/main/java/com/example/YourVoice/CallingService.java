package com.example.YourVoice;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.IBinder;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.widget.Toast;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

public class CallingService extends Service {
    public static final String EXTRA_CALL_NUMBER = "call_number";
    protected View rootView;
    Button btn_stt;
    ImageButton btn_close;

    Intent intent;
    SpeechRecognizer mRecognizer;
    Button sttBtn;
    TextView textView;
    final int PERMISSION = 1;


    @BindView(R.id.tv_call_number)
    TextView tv_call_number;
    String call_number;
    WindowManager.LayoutParams params;
    private WindowManager windowManager;

    @Override
    public IBinder onBind(Intent intent) {

        // Not used
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();

        int width = (int) (display.getWidth() * 0.9); //Display 사이즈의 90%
        params = new WindowManager.LayoutParams(
                width,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                        | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                        | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON,
                PixelFormat.TRANSLUCENT);


        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


        rootView = layoutInflater.inflate(R.layout.call, null);
        btn_stt = (Button) rootView.findViewById(R.id.btn_stt);
        btn_close = (ImageButton) rootView.findViewById(R.id.btn_close);
//        ButterKnife.bind(this, rootView);
        setDraggable();

        intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getPackageName());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,"ko-KR");

        btn_stt.setOnClickListener(v -> {
            mRecognizer= SpeechRecognizer.createSpeechRecognizer(this);
            mRecognizer.setRecognitionListener(listener);
            mRecognizer.startListening(intent);
        });

        btn_close.setOnClickListener(v -> {
            stopService(intent);
        });


    }

    private RecognitionListener listener = new RecognitionListener() {
        @Override
        public void onReadyForSpeech(Bundle params) {
            Toast.makeText(getApplicationContext(),"음성인식을 시작합니다.",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBeginningOfSpeech() {}

        @Override
        public void onRmsChanged(float rmsdB) {}

        @Override
        public void onBufferReceived(byte[] buffer) {}

        @Override
        public void onEndOfSpeech() {}

        @Override
        public void onError(int error) {
            String message;

            switch (error) {
                case SpeechRecognizer.ERROR_AUDIO:
                    message = "오디오 에러";
                    break;
                case SpeechRecognizer.ERROR_CLIENT:
                    message = "클라이언트 에러";
                    break;
                case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                    message = "퍼미션 없음";
                    break;
                case SpeechRecognizer.ERROR_NETWORK:
                    message = "네트워크 에러";
                    break;
                case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                    message = "네트웍 타임아웃";
                    break;
                case SpeechRecognizer.ERROR_NO_MATCH:
                    message = "찾을 수 없음";
                    break;
                case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                    message = "RECOGNIZER가 바쁨";
                    break;
                case SpeechRecognizer.ERROR_SERVER:
                    message = "서버가 이상함";
                    break;
                case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                    message = "말하는 시간초과";
                    break;
                default:
                    message = "알 수 없는 오류임";
                    break;
            }

            Toast.makeText(getApplicationContext(), "에러가 발생하였습니다. : " + message,Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResults(Bundle results) {
            // 말을 하면 ArrayList에 단어를 넣고 textView에 단어를 이어줍니다.
            ArrayList<String> matches =
                    results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

            for(int i = 0; i < matches.size() ; i++){
                textView.setText(matches.get(i));
                try {
                    writeDataToCsv("/Alarms/test.csv", matches);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void writeDataToCsv(String filePath, ArrayList<String> text) throws IOException {
            CSVWriter writer = new CSVWriter(new FileWriter(filePath));

            for(int i = 0; i < text.size() ; i++){
                textView.setText(text.get(i));
                try {
                    writeDataToCsv("/Alarms/test.csv", text);
                    String[] entries = text.toArray(new String[0]);  // 1
                    writer.writeNext(entries);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            writer.close();
        }



        @Override
        public void onPartialResults(Bundle partialResults) {}

        @Override
        public void onEvent(int eventType, Bundle params) {}
    };


    private void setDraggable() {

        rootView.setOnTouchListener(new View.OnTouchListener() {
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);

                        if (rootView != null)
                            windowManager.updateViewLayout(rootView, params);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        windowManager.addView(rootView, params);
        setExtra(intent);

        if (!TextUtils.isEmpty(call_number)) {
            tv_call_number.setText(call_number);
        }
        return START_REDELIVER_INTENT;
    }

    private void setExtra(Intent intent) {

        if (intent == null) {
            removePopup();
            return;
        }

        call_number = intent.getStringExtra(EXTRA_CALL_NUMBER);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        removePopup();
    }


    @OnClick(R.id.btn_close)
    public void removePopup() {
        if (rootView != null || windowManager != null) windowManager.removeView(rootView);

    }






}

