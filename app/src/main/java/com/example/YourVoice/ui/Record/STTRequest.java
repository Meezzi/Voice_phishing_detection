package com.example.YourVoice.ui.Record;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class STTRequest extends StringRequest {
    final static private String URL = "http://192.168.0.5/app/result.php"; // "http:// 퍼블릭 DSN 주소/Login.php";
    private Map<String, String> parameters;

    public STTRequest(String sttResult, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();
        parameters.put("sttResult", sttResult);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parameters;
    }
}
