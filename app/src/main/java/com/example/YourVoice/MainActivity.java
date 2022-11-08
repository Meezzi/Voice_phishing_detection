package com.example.YourVoice;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.speech.SpeechRecognizer;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.YourVoice.ui.CallLog.CallLogFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.YourVoice.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> nameList;
    private ArrayList<String> numberList;

    Intent intent;
    SpeechRecognizer mRecognizer;
    Button sttBtn;
    TextView textView;
    final int PERMISSION = 1;
    private ActivityMainBinding binding;
    int nCurrentPermission = 0;
    static final int PERMISSIONS_REQUEST=0X0000001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_callLog, R.id.navigation_record, R.id.navigation_list, R.id.navigation_myPage)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        PermissionCheck();

        getAddressBooks();


    }


    public void PermissionCheck(){
        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_DENIED||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED||
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_DENIED||
                ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.INTERNET)==PackageManager.PERMISSION_DENIED
        )

            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_CALL_LOG,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_CONTACTS,
                    Manifest.permission.INTERNET
            },0);
        if (!Settings.canDrawOverlays(getApplicationContext())) {
            checkOverlayPermission();
        }
    }

    private void checkOverlayPermission() {
        try {
            Uri uri = Uri.parse("package:" + getPackageName());
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, uri);
            startActivityForResult(intent, 5469);
        } catch (Exception e) {
        }
    }

    public void ChangeCallActivity(String callNumber){
        Intent intent = new Intent(getApplicationContext(), CallLogFragment.class);
        intent.putExtra("phone",callNumber);
        startActivity(intent);
    }

    public void getAddressBooks ()
    {
        //주소록 가져오는 부분
        nameList = new ArrayList();
        numberList = new ArrayList();

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI,
                null,null,null,
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY + " asc");

        while(c.moveToNext()){
            //연락처 id 값
            @SuppressLint("Range") String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID)); // 아이디 가져온다.
            @SuppressLint("Range") String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY)); //이름을 가져온다.
            nameList.add(name);

            Cursor phoneCursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id,
                    null,null);

            if(phoneCursor.moveToNext()){
                @SuppressLint("Range") String number = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                Log.d("Test number",number);
                numberList.add(number);
            }
            phoneCursor.close();
        }
        c.close();

    }

    public ArrayList getNumbers(){
        return this.numberList;
    }
    public ArrayList getNames(){
        return this.nameList;
    }

}