package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityAppointmentsBinding;

public class AppointmentsActivity extends AppCompatActivity {

    Context mContext = AppointmentsActivity.this;
    ActivityAppointmentsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointments);

        init();

    }

    private void init() {

      binding.ivBack.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ChatingActivity.class));
      });

      binding.chat1.setOnClickListener(v -> {
        startActivity(new Intent(mContext,ChatingActivity.class));
      });

      binding.chat2.setOnClickListener(v -> {
          startActivity(new Intent(mContext,ChatingActivity.class));
      });


    }


}
