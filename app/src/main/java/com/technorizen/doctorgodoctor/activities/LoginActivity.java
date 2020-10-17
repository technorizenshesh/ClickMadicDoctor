package com.technorizen.doctorgodoctor.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.technorizen.doctorgodoctor.Constant.BaseClass;
import com.technorizen.doctorgodoctor.R;
import com.technorizen.doctorgodoctor.register.LoadRegisterActivity;
import com.technorizen.doctorgodoctor.databinding.ActivityLoginBinding;
import com.utils.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class LoginActivity extends AppCompatActivity {

    Context mContext = LoginActivity.this;
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        init();

    }

    private void init() {

        binding.tvSignUp.setOnClickListener(v -> {
            startActivity(new Intent(mContext, LoadRegisterActivity.class));
        });

        binding.rlLogin.setOnClickListener(v -> {
         if (Validation()){
             Continue();
         }
        });

        binding.tvForgotPass.setOnClickListener(v -> {
            startActivity(new Intent(mContext,ForgotPassActivity.class));
        });

    }
    private HashMap<String,String> getParam(){
        HashMap<String,String>param=new HashMap<>();
        param.put("email",binding.email.getText().toString());
        param.put("password",binding.password.getText().toString());
        param.put("register_id","rrr");
        param.put("lat","0.0");
        param.put("lon","0.0");
        return param;
    }
    private void Continue() {
        ApiCallBuilder.build(this).setUrl(BaseClass.get().Login())
                .isShowProgressBar(true)
                .setParam(getParam()).execute(new ApiCallBuilder.onResponse() {
            @Override
            public void Success(String response) {
                try {
                    JSONObject object=new JSONObject(response);
                    boolean status=object.getString("status").contains("1");
                    if (status){
                        SessionManager.get(LoginActivity.this).CreateSession(object.getString("result"));
                        startActivity(new Intent(mContext,HomeActivity.class));
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

    private boolean Validation(){
        if (binding.email.getText().toString().isEmpty()){
            binding.email.setError(getString(R.string.required));
            binding.email.requestFocus();
            return false;
        }
        if (binding.password.getText().toString().isEmpty()){
            binding.password.setError(getString(R.string.required));
            binding.password.requestFocus();
            return false;
        }
        return true;
    }

}
