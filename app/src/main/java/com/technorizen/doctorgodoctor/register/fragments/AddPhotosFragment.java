package com.technorizen.doctorgodoctor.register.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.activities.HomeActivity;
import com.technorizen.doctorgodoctor.databinding.FragmentAddPhotosBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPhotosFragment extends Fragment {

    Context mContext;
    FragmentAddPhotosBinding binding;

    public AddPhotosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_photos, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.rlNext.setOnClickListener(v -> {
            startActivity(new Intent(mContext, HomeActivity.class));
        });

    }


}
