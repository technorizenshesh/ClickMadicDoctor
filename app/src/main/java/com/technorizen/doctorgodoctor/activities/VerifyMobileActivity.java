package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.technorizen.doctorgodoctor.Constant.BaseClass;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;
import com.technorizen.doctorgodoctor.databinding.ActivityVerifyMobileBinding;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class VerifyMobileActivity extends AppCompatActivity {

    Context mContext = VerifyMobileActivity.this;
    ActivityVerifyMobileBinding binding;
    private boolean isValid=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_verify_mobile);
        init();
    }

    private void init() {
        binding.et1.addTextChangedListener(watcher);
        binding.et2.addTextChangedListener(watcher);
        binding.et3.addTextChangedListener(watcher);
        binding.et4.addTextChangedListener(watcher);
        binding.resendOtp.setOnClickListener(v->ResendOtp());
        binding.btContinue.setOnClickListener(v -> {
            if (isValid)
                Continue();
        });
    }
    private HashMap<String,String> getParam(){
        String otp=binding.et1.getText().toString()+binding.et2.getText().toString()+binding.et3.getText().toString()+binding.et4.getText().toString();
        HashMap<String,String>param=new HashMap<>();
        param.put("user_id", SessionManager.get(this).getUserID());
        param.put("otp",otp);
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().checkOtp())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    Toast.makeText(mContext, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                    if (status){
                        SessionManager.get(VerifyMobileActivity.this).CreateSession(object.getString("result"));
                        startActivity(new Intent(mContext,LoadRegisterActivity.class));
                        finish();
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
    private void ResendOtp() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().resendOtp())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    Toast.makeText(mContext, ""+object.getString("message"), Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void Failed(String error) {

            }
        });
    }
    TextWatcher watcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (binding.et1.getText().toString().isEmpty()){
                binding.et1.requestFocus();
                return;
            }
            if (binding.et2.getText().toString().isEmpty()){
                binding.et2.requestFocus();
                return;
            }
            if (binding.et3.getText().toString().isEmpty()){
                binding.et3.requestFocus();
                return;
            }
            if (binding.et4.getText().toString().isEmpty()){
                binding.et4.requestFocus();
                return;
            }
            isValid=true;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
