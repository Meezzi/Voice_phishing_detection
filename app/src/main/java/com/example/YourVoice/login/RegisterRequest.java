package com.example.YourVoice.login;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;


public class RegisterRequest extends StringRequest  {
    // 서버 url 설정 (mongoDB 연동)
    final static private String URL = "http://192.168.0.5/register.php"; // "http:// 퍼블릭 DNS 주소/Register.php"
    private Map<String, String> parameters;
    public RegisterRequest(String email, String pwck, String name, String area, String age, String phone, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        parameters = new HashMap<>();
        parameters.put("user_email", email);
        parameters.put("user_pw",pwck);
        parameters.put("user_name",name);
        parameters.put("user_area", area);
        parameters.put("user_age", age);
        parameters.put("user_phone", phone);
    }
    @Override
    protected Map<String, String> getParams() {
        return parameters;
    }
}

