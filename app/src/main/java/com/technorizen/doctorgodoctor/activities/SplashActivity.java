package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.technorizen.doctorgodoctor.R;
import com.utils.Session.SessionManager;

public class SplashActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSION = 2;
    boolean isAccepted=false;
    String[] mPermission = {
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    Context mContext = SplashActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ActivityCompat.requestPermissions(this, mPermission, REQUEST_CODE_PERMISSION);


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int i:grantResults){
            isAccepted=i==0;
            if (!isAccepted)break;
        }
        if (isAccepted) {
            Handlers();
        } else {
            ActivityCompat.requestPermissions(this, mPermission, REQUEST_CODE_PERMISSION);
        }
    }
    void Handlers(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SessionManager.get(mContext).isUserLogin()){
                    startActivity(new Intent(mContext,HomeActivity.class));
                }else {
                    startActivity(new Intent(mContext,IntroActivity.class));
                }
                finish();
            }
        },1000);
    }

}
