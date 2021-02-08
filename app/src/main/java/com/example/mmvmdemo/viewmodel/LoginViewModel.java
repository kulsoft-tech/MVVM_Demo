package com.example.mmvmdemo.viewmodel;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mmvmdemo.repositories.LoginRepository;
import com.example.mmvmdemo.utils.MyListener;

public class LoginViewModel extends ViewModel {

    public String email;
    public String password;
    private LiveData<String> loginResponse;

    LoginRepository loginRepository;

    MyListener myListener;

    public void attempLogin(View v){
        if(email.isEmpty() || password.isEmpty()) {
            myListener.onFailure("Invalid username & password");
            return;
        }
        if(loginRepository == null) {
            loginRepository  =LoginRepository.getInstance();
        }

      //  myListener.OnStart();

        loginResponse = loginRepository.login(email, password);

      //  myListener.onSucess(loginResponse);
    }
}
