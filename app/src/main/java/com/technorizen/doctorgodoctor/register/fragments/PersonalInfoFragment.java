package com.technorizen.doctorgodoctor.register.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentPersonalInfoBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

public class PersonalInfoFragment extends Fragment {

    Context mContext;
    FragmentPersonalInfoBinding binding;

    public PersonalInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_personal_info, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {
        binding.rlNext.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new PersonalInfo2Fgrament());
        });

    }

}
