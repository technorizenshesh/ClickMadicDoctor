package com.technorizen.doctorgodoctor.medicalprescription;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;

import com.technorizen.doctorgodoctor.MainActivity;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.activities.HomeActivity;
import com.technorizen.doctorgodoctor.databinding.ActivityMedicalPrescriptioncAtivityBinding;

public class MedicalPrescriptioncAtivity extends AppCompatActivity {

    Context mContext = MedicalPrescriptioncAtivity.this;
    ActivityMedicalPrescriptioncAtivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_medical_prescriptionc_ativity);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

        binding.injectionTerlyz.setOnClickListener(v -> {
            savePrescriptionDialog();
        });

        binding.capsule.setOnClickListener(v -> {
            addMorePrescriptionDialog();
        });


    }

    private void savePrescriptionDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.save_prescription_dialog);

        Button save = dialog.findViewById(R.id.save);
        ImageView ivBack = dialog.findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            addMorePrescriptionDialog();
        });

        dialog.show();

    }


    private void addMorePrescriptionDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.add_more_prescription_dialog);

        Button save = dialog.findViewById(R.id.save);
        ImageView ivBack = dialog.findViewById(R.id.ivBack);
        Button btAddMore = dialog.findViewById(R.id.btAddMore);
        RelativeLayout rlCapsule = dialog.findViewById(R.id.rlCapsule);

        ivBack.setOnClickListener(v -> {
            dialog.dismiss();
        });

        rlCapsule.setOnClickListener(v -> {
            dialog.dismiss();
            deletePrescriptionDialog();
        });

        save.setOnClickListener(v -> {
            PrescriptionDetailsDialog();
        });

        btAddMore.setOnClickListener(v -> {
            finish();
            startActivity(new Intent(mContext,MedicalPrescriptioncAtivity.class));
        });

        dialog.show();

    }


    private void deletePrescriptionDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.delete_prescription_dialog);

        Button save = dialog.findViewById(R.id.save);
        Button delete = dialog.findViewById(R.id.delete);
        ImageView ivBack = dialog.findViewById(R.id.ivBack);

        ivBack.setOnClickListener(v -> {
            dialog.dismiss();
        });

        delete.setOnClickListener(v -> {
            dialog.dismiss();
        });

        save.setOnClickListener(v -> {
            finish();
        });

        dialog.show();

    }

    private void PrescriptionDetailsDialog() {

        Dialog dialog = new Dialog(mContext, WindowManager.LayoutParams.MATCH_PARENT);
        dialog.setContentView(R.layout.save_prescription_detail_dialog);

        ImageView ivBack = dialog.findViewById(R.id.ivBack);
        ImageView menu = dialog.findViewById(R.id.menu);

        menu.setOnClickListener(v -> {
            //Creating the instance of PopupMenu
            PopupMenu popup = new PopupMenu(mContext, menu);
            //Inflating the Popup using xml file
            popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

            //registering popup with OnMenuItemClickListener
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                public boolean onMenuItemClick(MenuItem item) {
                    return true;
                }
            });

            popup.show();//showing popup menu
        });

        ivBack.setOnClickListener(v -> {
            dialog.dismiss();
            startActivity(new Intent(mContext, HomeActivity.class));
        });


        dialog.show();

    }

}
