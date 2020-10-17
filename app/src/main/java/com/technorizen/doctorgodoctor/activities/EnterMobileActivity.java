package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.Constant.BaseClass;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.databinding.ActivityEnterMobileBinding;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class EnterMobileActivity extends AppCompatActivity {

    Context mContext = EnterMobileActivity.this;
    ActivityEnterMobileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_enter_mobile);

        init();

    }

    private void init() {
        binding.rlSubmit.setOnClickListener(v -> {
            if (binding.etMobile.getText().toString().isEmpty()){
                binding.etMobile.setError(getString(R.string.required));
                binding.etMobile.requestFocus();
                return;
            }
            Continue();
        });

        binding.ivBack.setOnClickListener(v -> {
            finish();
        });

    }

    private HashMap<String,String> getParam(){
        HashMap<String,String>param=new HashMap<>();
        param.put("mobile",binding.etMobile.getText().toString());
        param.put("user_type","Client");
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().registerMobile())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    if (status){
                        SessionManager.get(EnterMobileActivity.this).CreateSession(object.getString("result"));
                        startActivity(new Intent(mContext,VerifyMobileActivity.class));
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
}
