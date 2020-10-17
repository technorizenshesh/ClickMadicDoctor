package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    Context mContext = WelcomeActivity.this;
    ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);

        init();

    }

    private void init() {
        binding.btNext.setOnClickListener(v -> {
            startActivity(new Intent(mContext,GetStartActivity.class));
        });
    }

}
