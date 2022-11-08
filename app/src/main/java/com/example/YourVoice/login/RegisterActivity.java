package com.example.YourVoice.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.YourVoice.R;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;


public class RegisterActivity extends AppCompatActivity {

    private static String IP_ADDRESS = "192.168.0.5/app/";
    private static String TAG = "phptest";

    private EditText join_email, join_pwck, join_name, join_area, join_age, join_phone;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        join_email = (EditText)findViewById(R.id.join_email);
        join_pwck = (EditText)findViewById(R.id.join_pwck);
        join_name = (EditText)findViewById(R.id.join_name);
        join_area = (EditText)findViewById(R.id.join_area);
        join_age = (EditText)findViewById(R.id.join_age);
        join_phone = (EditText)findViewById(R.id.join_phone);


        mTextViewResult = (TextView)findViewById(R.id.textView_main_result);

        mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        Button btn_login = (Button)findViewById(R.id.login_button);
        btn_login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });


        Button btn_join = (Button)findViewById(R.id.join_button);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_email = join_email.getText().toString();
                String user_pw = join_pwck.getText().toString();
                String user_name = join_name.getText().toString();
                String user_area = join_area.getText().toString();
                String user_age = join_age.getText().toString();
                String user_phone = join_phone.getText().toString();

                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/insert.php", user_email, user_pw, user_name, user_area, user_age, user_phone);

                join_email.setText("");
                join_pwck.setText("");
                join_name.setText("");
                join_area.setText("");
                join_age.setText("");
                join_phone.setText("");

            }
        });

    }



    class InsertData extends AsyncTask<String, Void, String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(RegisterActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);
            Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String user_email = (String)params[1];
            String user_pw = (String)params[2];
            String user_name = (String)params[3];
            String user_area = (String)params[4];
            String user_age = (String)params[5];
            String user_phone = (String)params[6];

            String serverURL = (String)params[0];
            String postParameters = "&user_email=" + user_email + "&user_pw=" + user_pw + "&user_name=" + user_name+ "&user_area=" + user_area + "&user_age=" + user_age + "&user_phone=" + user_phone ;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                Log.d(TAG, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }


}