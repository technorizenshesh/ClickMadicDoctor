package com.technorizen.doctorgodoctor.register.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentAddClinicProfileFrgamentBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

public class AddClinicProfileFrgament extends Fragment {

    Context mContext;
    FragmentAddClinicProfileFrgamentBinding binding;

    public AddClinicProfileFrgament() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_clinic_profile_frgament, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.llClinicDocUpload.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new ClinicinfoFragment());
        });

        binding.llClinicPart.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new SerachForClinicFragment());
        });

        binding.llAddSchedule.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AvailabilityFragment());
        });

    }


}
