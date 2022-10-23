package com.example.YourVoice.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;


public class RegisterRequest extends StringRequest  {
    // 서버 url 설정 (mongoDB 연동)
    final static private String URL = "http://localhost/phpmyadmin/index.php?route=/table/structure&db=app&table=test"; // "http:// 퍼블릭 DNS 주소/Register.php"
    private Map<String, String> parameters;
    public RegisterRequest(String userName, String userPhonenumber, String rrn, String userID, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("userName", userName);
        parameters.put("userPhoneNumber",userPhonenumber);
        parameters.put("userRrn",rrn);
        parameters.put("userID", userID);
    }
    @Override
    protected Map<String, String> getParams() {
        return parameters;
    }
}

