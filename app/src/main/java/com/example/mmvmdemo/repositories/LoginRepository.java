package com.example.mmvmdemo.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mmvmdemo.MyApi.RestApi;
import com.example.mmvmdemo.MyApi.RetrofitClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    public static LoginRepository loginRepository;
    RestApi restApi = RetrofitClient.get();

    public static LoginRepository getInstance() {
        if(loginRepository == null) {
            loginRepository = new LoginRepository();
        }
        return loginRepository;
    }

    public LiveData<String> login(String username, String password){
        MutableLiveData<String> res = new MutableLiveData<>();
        restApi.login(username,password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    res.setValue(response.body().toString());
                }else {
                    res.setValue(response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                res.setValue(t.getMessage());
            }
        });

        return res;
    }



}
