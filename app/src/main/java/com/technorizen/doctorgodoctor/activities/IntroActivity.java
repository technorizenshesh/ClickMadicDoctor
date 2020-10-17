package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityIntroBinding;
import com.utils.Session.SessionManager;

public class IntroActivity extends AppCompatActivity {

    Context mContext = IntroActivity.this;
    ActivityIntroBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_intro);

        init();

    }

    private void init() {
        SessionManager manager=SessionManager.get(mContext);
        binding.Laboratory.setOnClickListener(v->{
            manager.setUserType("Laboratory");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });binding.Insurance.setOnClickListener(v->{
            manager.setUserType("Insurance");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });binding.Company.setOnClickListener(v->{
            manager.setUserType("Company");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });binding.Nurse.setOnClickListener(v->{
            manager.setUserType("Nurse");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });binding.Doctor.setOnClickListener(v->{
            manager.setUserType("Doctor");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });binding.Pharmacy.setOnClickListener(v->{
            manager.setUserType("Pharmacy");
            startActivity(new Intent(mContext,WelcomeActivity.class));
        });
    }


}
