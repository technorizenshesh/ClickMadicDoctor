package com.technorizen.doctorgodoctor.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.activities.HomeActivity;
import com.technorizen.doctorgodoctor.databinding.FragmentMyRequestBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRequestFragment extends Fragment {

    Context mContext;
    FragmentMyRequestBinding binding;

    public MyRequestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_request, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    private void init() {

        binding.activeView.setVisibility(View.VISIBLE);
        getChildFragmentManager().beginTransaction().replace(R.id.frame_container,new ActiveRequestFragment()).commit();

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.tvActive.setOnClickListener(v -> {
            binding.activeView.setVisibility(View.VISIBLE);
            binding.ScheduledView.setVisibility(View.INVISIBLE);
            binding.CompleteView.setVisibility(View.INVISIBLE);
        });

        binding.tvSchedule.setOnClickListener(v -> {
            binding.activeView.setVisibility(View.INVISIBLE);
            binding.ScheduledView.setVisibility(View.VISIBLE);
            binding.CompleteView.setVisibility(View.INVISIBLE);
        });

        binding.tvComplete.setOnClickListener(v -> {
            binding.activeView.setVisibility(View.INVISIBLE);
            binding.ScheduledView.setVisibility(View.INVISIBLE);
            binding.CompleteView.setVisibility(View.VISIBLE);
        });

    }

}
