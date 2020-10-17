package com.technorizen.doctorgodoctor.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityHomeBinding;
import com.technorizen.doctorgodoctor.fragments.HomeFragment;
import com.technorizen.doctorgodoctor.fragments.MedicalNetworksFragment;
import com.technorizen.doctorgodoctor.fragments.MyProfileFragment;
import com.technorizen.doctorgodoctor.fragments.MyRequestFragment;
import com.technorizen.doctorgodoctor.utils.ActionBottomDialogFragment;

public class HomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ActionBottomDialogFragment.ItemClickListener{

    Context mContext = HomeActivity.this;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);

        init();

    }

    private void init() {

        binding.navView.setOnNavigationItemSelectedListener(this);

        FragTras(new HomeFragment());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.nav_home:
                FragTras(new HomeFragment());
                break;

            case R.id.nav_network:
                FragTras(new MedicalNetworksFragment());
                break;

            case R.id.nav_requests:
                FragTras(new MyRequestFragment());
                break;

            case R.id.navi_chats_calls:
                 startActivity(new Intent(mContext,AppointmentsActivity.class));
                break;

            case R.id.navi_profile:
                FragTras(new MyProfileFragment());
                break;

        }

        return true;

    }

    public void FragTras(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()>1){
            super.onBackPressed();
        } else {
            finish();
        }
    }


    @Override
    public void onItemClick(String item) {

    }

}
