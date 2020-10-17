package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityGetStartBinding;

public class GetStartActivity extends AppCompatActivity {

    Context mContext = GetStartActivity.this;
    ActivityGetStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_get_start);

        init();

    }

    private void init() {

        binding.cvMobile.setOnClickListener(v -> {
            startActivity(new Intent(mContext,EnterMobileActivity.class));
        });

        binding.tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(mContext,LoginActivity.class));
        });

    }

}
