package com.technorizen.doctorgodoctor.clinichistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.clinichistory.fragments.ClinicHistoryFragment;
import com.technorizen.doctorgodoctor.clinichistory.fragments.PersonalDoctorInfoFragment;
import com.technorizen.doctorgodoctor.databinding.ActivityClinicHistoryBinding;
import com.technorizen.doctorgodoctor.register.fragments.ClinicinfoFragment;
import com.technorizen.doctorgodoctor.register.fragments.PersonalInfoFragment;

public class ClinicHistoryActivity extends AppCompatActivity {

    Context mContext = ClinicHistoryActivity.this;
    ActivityClinicHistoryBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_clinic_history);
        
        init();
        
    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new PersonalDoctorInfoFragment()).commit();
        binding.personalInfoView.setVisibility(View.VISIBLE);

        binding.tvPersonalInfo.setOnClickListener(v -> {
            binding.personalInfoView.setVisibility(View.VISIBLE);
            binding.clinicHistoryView.setVisibility(View.INVISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new PersonalDoctorInfoFragment()).commit();
        });

        binding.tvClinicHistory.setOnClickListener(v -> {
            binding.personalInfoView.setVisibility(View.INVISIBLE);
            binding.clinicHistoryView.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new ClinicHistoryFragment()).commit();
        });

    }


}
