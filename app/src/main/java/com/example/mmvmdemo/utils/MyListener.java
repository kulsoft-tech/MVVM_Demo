package com.example.mmvmdemo.utils;

import androidx.lifecycle.LiveData;

public interface MyListener {

    public void onSucess(LiveData<String> msg);
    public void onFailure(String msg);
    public void OnStart();
}
