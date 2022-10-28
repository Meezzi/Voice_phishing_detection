package com.example.YourVoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Log;

public class IncomingCallBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "PHONE STATE";
    private static String mLastState;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.d(TAG,"onReceive()");
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(mLastState)) {
            return;
        } else {
            mLastState = state;
        }
        if (TelephonyManager.EXTRA_STATE_OFFHOOK.equals(state)) { //TelephonyManager.CALL_STATE_OFFHOOK TelephonyManager.EXTRA_STATE_RINGING
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            //final String phone_number = PhoneNumberUtils.formatNumber(incomingNumber);
            Intent serviceIntent = new Intent(context, CallingService.class);
            //serviceIntent.putExtra(CallingService.EXTRA_CALL_NUMBER, phone_number);
            context.startService(serviceIntent);
        }
    }
}


