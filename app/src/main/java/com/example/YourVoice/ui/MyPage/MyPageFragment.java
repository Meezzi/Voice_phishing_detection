package com.example.YourVoice.ui.MyPage;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.YourVoice.R;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MyPageFragment extends Fragment {

    View view;

    private static String IP_ADDRESS = "192.168.0.5/app";
    private static String TAG = "phptest";

    private EditText mEditTextName;
    private EditText mEditTextEmail;
    private EditText mEditTexPhone;
    private EditText mEditTextArea;

    private TextView mTextViewResult;
    private ArrayList<PersonalData> mArrayList;
    private UsersAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;

    @Override //프래그먼트 생성시에 뷰(화면)를 구성하는 메소드
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mypage,null); //view를 불러온다.
        //SetLayout(view);

        return view;
    }


    private void showResult(){

        String TAG_JSON="webnautes";

        String TAG_NAME = "name";
        String TAG_EMAIL = "email";
        String TAG_PHONE ="phone";
        String TAG_AREA = "area";


        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String name = item.getString(TAG_NAME);
                String email = item.getString(TAG_EMAIL);
                String phone = item.getString(TAG_PHONE);
                String area = item.getString(TAG_AREA);

                PersonalData personalData = new PersonalData();

                personalData.setuser_name(name);
                personalData.setuser_email(email);
                personalData.setuser_phpone(phone);
                personalData.setuser_area(area);

                mArrayList.add(personalData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}