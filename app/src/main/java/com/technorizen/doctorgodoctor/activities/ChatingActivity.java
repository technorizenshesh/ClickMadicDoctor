package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityChatingBinding;

public class ChatingActivity extends AppCompatActivity {

    Context mContext = ChatingActivity.this;
    ActivityChatingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chating);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

    }

}
