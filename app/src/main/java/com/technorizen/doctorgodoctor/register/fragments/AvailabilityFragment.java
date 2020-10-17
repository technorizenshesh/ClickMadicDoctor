package com.technorizen.doctorgodoctor.register.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentAvailabilityBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;

import org.w3c.dom.Text;

public class AvailabilityFragment extends Fragment {

    Context mContext;
    FragmentAvailabilityBinding binding;

    public AvailabilityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_availability, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        binding.rlNext.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AddCertificatesFragment());
        });

        binding.time1.setOnClickListener(v -> {
            timePickerDialog();
        });

        binding.time2.setOnClickListener(v -> {
            timePickerDialog();
        });

        binding.time3.setOnClickListener(v -> {
            timePickerDialog();
        });

        binding.time4.setOnClickListener(v -> {
            timePickerDialog();
        });

    }

    private void timePickerDialog() {

        Dialog dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.custom_time_picker_dialog);

        TimePicker timePicker = dialog.findViewById(R.id.timePicker);
        TextView tvCancel = dialog.findViewById(R.id.tvCancel);
        TextView tvNext = dialog.findViewById(R.id.tvNext);

        disable(timePicker);
        timePicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);

        timePicker.setEnabled(false);
        hideTimeHeaderLayout(timePicker);

        tvNext.setOnClickListener(v -> {
            ((LoadRegisterActivity)getActivity()).loadFragment(new AddCertificatesFragment());
            dialog.dismiss();
        });

        tvCancel.setOnClickListener(v -> {
            dialog.dismiss();
        });

        dialog.show();

    }

    private void disable(ViewGroup vg)
    {
        for (int i = 0; i < vg.getChildCount(); ++i)
        {
            View v = vg.getChildAt(i);
            if (v instanceof ViewGroup)
            {
                disable((ViewGroup)v);
            }
            else
            {
                v.setEnabled(false);
            }
        }
    }

    private void hideTimeHeaderLayout(TimePicker picker) {
        final int id = Resources.getSystem().getIdentifier("time_header", "id", "android");
        final View timeLayout = picker.findViewById(id);
        if(timeLayout != null) {
            timeLayout.setVisibility(View.GONE);
        }
    }


}
