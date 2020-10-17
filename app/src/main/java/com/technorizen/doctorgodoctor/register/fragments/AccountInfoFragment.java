package com.technorizen.doctorgodoctor.register.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.technorizen.doctorgodoctor.Constant.BaseClass;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.FragmentAccountInfoBinding;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountInfoFragment extends Fragment {

    Context mContext;
    FragmentAccountInfoBinding binding;
    private SessionManager session;

    public AccountInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_account_info, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {
        session= SessionManager.get(getContext());
        binding.rlNext.setOnClickListener(v -> {
            if (Validation()){
                Continue();
            }
        });

    }
    private HashMap<String,String> getParam(){
        RadioButton button=binding.getRoot().findViewById(binding.gender.getCheckedRadioButtonId());
        HashMap<String,String>param=new HashMap<>();
        param.put("user_id",session.getUserID());
        param.put("first_name",binding.name.getText().toString());
        param.put("email",binding.email.getText().toString());
        param.put("password",binding.password.getText().toString());
        param.put("height",binding.height.getText().toString());
        param.put("age",binding.age.getText().toString());
        param.put("gender",button.getText().toString());
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(getContext()).setUrl(BaseClass.get().updateProfile())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    if (status){
                        session.setUserLogin(true);
                        session.CreateSession(object.getString("result"));
                        ((LoadRegisterActivity)getActivity()).loadFragment(new PersonalInfoFragment());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void Failed(String error) {

            }
        });
    }

    private boolean Validation(){
        if (binding.name.getText().toString().isEmpty()){
            binding.name.setError(getString(R.string.required));
            binding.name.requestFocus();
            return false;
        }if (binding.email.getText().toString().isEmpty()){
            binding.email.setError(getString(R.string.required));
            binding.email.requestFocus();
            return false;
        }
        if (binding.password.getText().toString().isEmpty()){
            binding.password.setError(getString(R.string.required));
            binding.password.requestFocus();
            return false;
        }if (binding.height.getText().toString().isEmpty()){
            binding.height.setError(getString(R.string.required));
            binding.height.requestFocus();
            return false;
        }if (binding.age.getText().toString().isEmpty()){
            binding.age.setError(getString(R.string.required));
            binding.age.requestFocus();
            return false;
        }
        return true;
    }

}
