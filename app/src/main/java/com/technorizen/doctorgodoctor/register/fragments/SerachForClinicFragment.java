package com.technorizen.doctorgodoctor.register.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentSerachForClinicBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

public class SerachForClinicFragment extends Fragment {

    Context mContext;
    FragmentSerachForClinicBinding binding;

    public SerachForClinicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_serach_for_clinic, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {
        binding.btEnterSchedule.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AvailabilityFragment());
        });
    }

}
