package com.example.mmvmdemo.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.databinding.ActivityLoginBinding;
import com.example.mmvmdemo.utils.MyListener;
import com.example.mmvmdemo.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements MyListener {

    EditText edtUsername, edtPassword;
    Button btnLogin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);

        LoginViewModel loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        activityLoginBinding.setLogin(loginViewModel);

    }

    @Override
    public void onSucess(LiveData<String> msg) {
        msg.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onFailure(String msg) {
        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void OnStart() {
        Toast.makeText(LoginActivity.this,"started",Toast.LENGTH_LONG).show();

    }
}
