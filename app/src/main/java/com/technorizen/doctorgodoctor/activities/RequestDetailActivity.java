package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityRequestDetailBinding;

public class RequestDetailActivity extends AppCompatActivity {

    Context mContext = RequestDetailActivity.this;
    ActivityRequestDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_request_detail);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

    }


}
