package com.technorizen.doctorgodoctor.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.activities.RequestDetailActivity;
import com.technorizen.doctorgodoctor.databinding.FragmentActiveRequestBinding;

public class ActiveRequestFragment extends Fragment {

    Context mContext;
    FragmentActiveRequestBinding binding;

    public ActiveRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_active_request, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.tvViewDetails.setOnClickListener(v -> {
            startActivity(new Intent(mContext, RequestDetailActivity.class));
        });

    }


}
