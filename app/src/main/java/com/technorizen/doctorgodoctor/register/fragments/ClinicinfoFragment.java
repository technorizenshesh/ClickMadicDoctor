package com.technorizen.doctorgodoctor.register.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentClinicinfoBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

public class ClinicinfoFragment extends Fragment {

    Context mContext;
    FragmentClinicinfoBinding binding;

    public ClinicinfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_clinicinfo, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.llEnterSchedule.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AvailabilityFragment());
        });

        binding.llClinicSchedule.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AvailabilityFragment());
        });

        binding.tvAdd.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AvailabilityFragment());
        });

    }


}
