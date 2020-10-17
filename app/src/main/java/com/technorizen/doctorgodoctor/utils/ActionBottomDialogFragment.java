package com.technorizen.doctorgodoctor.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.clinichistory.ClinicHistoryActivity;
import com.technorizen.doctorgodoctor.medicalprescription.MedicalPrescriptioncAtivity;

public class ActionBottomDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener{

    public static final String TAG = "ActionBottomDialog";
    private ItemClickListener mListener;
    private Context mContext;
    SeekBar sbRadius;
    LinearLayout llMedicalPrescription,tvClinichistory;
    boolean checkupDown = true;
    TextView tvEventName,tvEventAddress,tvArtist,tvGenre,ShowLessMore,tvOpenTime,tvClosedTime,tvAgeLimit,tvDate,tvDiscription;
    static String newName;

    public static ActionBottomDialogFragment newInstance(Context mContext) {
        return new ActionBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();

        View view = inflater.inflate(R.layout.bottom_sheet_start, container, false);

        init(view);

        return view;
        
    }

    private void init(View view) {

        llMedicalPrescription = view.findViewById(R.id.llMedicalPrescription);
        tvClinichistory = view.findViewById(R.id.tvClinichistory);

        llMedicalPrescription.setOnClickListener(v -> {
            dismiss();
            startActivity(new Intent(mContext, MedicalPrescriptioncAtivity.class));
        });

        tvClinichistory.setOnClickListener(v -> {
            dismiss();
            startActivity(new Intent(mContext, ClinicHistoryActivity.class));
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ItemClickListener) {
            mListener = (ItemClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

    }

    public interface ItemClickListener {
        void onItemClick(String item);
    }


}
