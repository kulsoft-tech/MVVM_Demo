package com.example.mmvmdemo.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.databinding.LayoutUserDetailsBinding;
import com.example.mmvmdemo.model.User;

public class UserDeTailsActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_user_details);


        LayoutUserDetailsBinding binding = DataBindingUtil.setContentView(this,R.layout.layout_user_details);

        user = new User();
        user.setName("Shyam Lokhande");
        user.setEmail("Shyamlokhande91111@gmail.com");

        binding.setUser(user);
    }
}
