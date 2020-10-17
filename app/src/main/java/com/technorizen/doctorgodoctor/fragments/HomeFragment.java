package com.technorizen.doctorgodoctor.fragments;

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
import com.technorizen.doctorgodoctor.activities.RequestDetailActivity;
import com.technorizen.doctorgodoctor.databinding.FragmentDashboardBinding;
import com.technorizen.doctorgodoctor.utils.ActionBottomDialogFragment;

public class HomeFragment extends Fragment implements ActionBottomDialogFragment.ItemClickListener{

    Context mContext;
    FragmentDashboardBinding binding;
    ActionBottomDialogFragment openBottomDialogFragment;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.tvViewDetails.setOnClickListener(v -> {
            startActivity(new Intent(mContext, RequestDetailActivity.class));
        });

        binding.ViewAll.setOnClickListener(v -> {
            ((HomeActivity)getActivity()).FragTras(new MyRequestFragment());
        });

        binding.ivMore.setOnClickListener(v -> {
            openBottomDialogFragment =
                    ActionBottomDialogFragment.newInstance(mContext);
            openBottomDialogFragment.show(getChildFragmentManager(),
                    ActionBottomDialogFragment.TAG);
        });


    }

    @Override
    public void onItemClick(String item) {

    }


}

