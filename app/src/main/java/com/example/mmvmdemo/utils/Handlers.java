package com.example.mmvmdemo.utils;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.example.mmvmdemo.model.User;

public class Handlers {

    User user;
    Context mCtx;

    public Handlers(Context mCtx) {
        this.mCtx = mCtx;
        user = new User();
    }


    public void OnClick(View v) {


    }

    public boolean onProfileImageLongPressed(View view) {
        Toast.makeText(mCtx, "Profile image long pressed!", Toast.LENGTH_LONG).show();
        return false;
    }

    public void OnProfileFabCliked(View view) {
        user.setName("Ram Lokhande");
        //user.setProfileImage("https://picsum.photos/200/300");

        //updating ObservableField
        user.numberOfFollowing.set(20L);
        user.numberOfFollowing.set(30L);
        user.numberOfPosts.set(10L);

    }

    public void OnPostClicked(View v) {
        Toast.makeText(mCtx, "Post is clicked!", Toast.LENGTH_SHORT).show();

    }

    public void onFollowersClicked(View v) {
        Toast.makeText(mCtx, "Followers is clicked!", Toast.LENGTH_SHORT).show();

    }

    public void onFollowingClicked(View v) {
        Toast.makeText(mCtx, "Following is clicked!", Toast.LENGTH_SHORT).show();

    }
}
