package com.technorizen.doctorgodoctor.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityLoadRegisterBinding;
import com.technorizen.doctorgodoctor.register.fragments.AccountInfoFragment;

public class LoadRegisterActivity extends AppCompatActivity {

    Context mContext = LoadRegisterActivity.this;
    ActivityLoadRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_register);

        init();

        loadFragment(new AccountInfoFragment());

    }

    private void init() {

    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.addToBackStack("fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }

    }

}
