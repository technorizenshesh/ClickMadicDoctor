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
import com.technorizen.doctorgodoctor.databinding.FragmentMyProfileBinding;
import com.technorizen.doctorgodoctor.fragments.profilefragments.HistoryFragment;
import com.technorizen.doctorgodoctor.fragments.profilefragments.ReviewsFragment;

public class MyProfileFragment extends Fragment {

    Context mContext;
    FragmentMyProfileBinding binding;

    public MyProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_profile, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.historyView.setVisibility(View.VISIBLE);
        getChildFragmentManager().beginTransaction().replace(R.id.frame_container,new HistoryFragment()).commit();

        binding.tvHistory.setOnClickListener(v -> {
            binding.historyView.setVisibility(View.VISIBLE);
            binding.reviewView.setVisibility(View.INVISIBLE);
            binding.settingView.setVisibility(View.INVISIBLE);
            getChildFragmentManager().beginTransaction().replace(R.id.frame_container,new HistoryFragment()).commit();
        });

        binding.tvReviews.setOnClickListener(v -> {
            binding.historyView.setVisibility(View.INVISIBLE);
            binding.reviewView.setVisibility(View.VISIBLE);
            binding.settingView.setVisibility(View.INVISIBLE);
            getChildFragmentManager().beginTransaction().replace(R.id.frame_container,new ReviewsFragment()).commit();
        });

        binding.tvSettings.setOnClickListener(v -> {
            binding.historyView.setVisibility(View.INVISIBLE);
            binding.reviewView.setVisibility(View.INVISIBLE);
            binding.settingView.setVisibility(View.VISIBLE);
            // getChildFragmentManager().beginTransaction().replace(R.id.frame_container,new HistoryFragment()).commit();
        });

       binding.ivFilter.setOnClickListener(v -> {
           ((HomeActivity)getActivity()).FragTras(new StatisticsFragment());
        });

    }


}
