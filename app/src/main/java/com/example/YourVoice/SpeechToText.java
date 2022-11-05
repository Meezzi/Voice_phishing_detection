//package com.example.YourVoice;
//
//import android.os.AsyncTask;
//import android.util.Log;
//import android.widget.TextView;
//import android.widget.Toast;
//
//
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.concurrent.Future;
//
//public class SpeechToText extends AsyncTask {
//
//    private static String speechSubscriptionKey = "920e15067413402fbbde3f577f92a796";
//    private static String serviceRegion = "koreacentral";
//    private String TAG = "STT";
//    public String txt;
//    public CallActivity callActivity;
//    public NetworkTask networkTask;
//    public TextView m_textView;
//    public String phoneNum;
//    public ConnectFirebase connectFirebase;
//    public TextView m_accuracy;
//
//    public SpeechToText(CallActivity callActivity1,TextView textView,String number,TextView accuracy){
//        callActivity = callActivity1;
//        m_textView = textView;
//        phoneNum = number;
//        m_accuracy = accuracy;
//        connectFirebase = new ConnectFirebase();
//    }
//    @Override
//    protected Object doInBackground(Object[] objects) {
//        while(true) {
//            try {
//                SpeechConfig config = SpeechConfig.fromSubscription(speechSubscriptionKey, serviceRegion);
//                assert (config != null);
//                Log.d(TAG,"1");
//
//                SpeechRecognizer reco = new SpeechRecognizer(config);
//                assert (reco != null);
//                Log.d(TAG,"2");
//
//                Future<SpeechRecognitionResult> task = reco.recognizeOnceAsync();
//                assert (task != null);
//                Log.d(TAG,"3");
//
//                SpeechRecognitionResult result = task.get();
//                assert (result != null);
//                Log.d(TAG,"4");
//
//                if (result.getReason() == ResultReason.RecognizedSpeech) {
//                    txt = result.toString();
//                } else {
//                    txt = result.toString();
//                }
//                Log.d(TAG,txt);
//
//                txt = txt.substring(txt.indexOf('<')+1,txt.indexOf('>'));
//                m_textView.setText(m_textView.getText() +" "+ txt);
//                sendToServer((String) m_textView.getText());
//                m_accuracy.setText(String.valueOf(connectFirebase.GetAccuracy(phoneNum)));
//                reco.close();
//            } catch (Exception ex) {
//                Log.d(TAG,"unexpected " + ex.getMessage());
//                assert (false);
//            }
//            if(isCancelled())
//                break;
//        }
//        Log.d(TAG,"end SpeechToText");
//        return null;
//    }
//    private void sendToServer(String txt) {
//        String url = "http://52.247.220.74/accuracy";
//
//        JSONObject jsonObject = FormatingData(txt, phoneNum);
//        networkTask = new NetworkTask(callActivity, url, jsonObject);
//        try {
//            networkTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    //서버에 요청할 데이터
//    private JSONObject FormatingData(String text, String phoneNumber){
//        JSONObject jsonObject = new JSONObject();
//        try {
//            jsonObject.accumulate("text", text);
//            jsonObject.accumulate("current_id", phoneNumber);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.d(TAG,phoneNumber + " : "+ text);
//        return jsonObject;
//    }
//
//}
