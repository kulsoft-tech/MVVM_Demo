package com.example.mmvmdemo.model;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mmvmdemo.BR;

public class User extends BaseObservable {

    String name;
    String email;
    String profileImage;
    String about;

    public User(){}

    // profile meta fields are ObservableField, will update the UI
    // whenever a new value is set
    public ObservableField<Long> numberOfFollowers = new ObservableField<>();
    public ObservableField<Long>  numberOfPosts  = new ObservableField<>();
    public ObservableField<Long>  numberOfFollowing = new ObservableField<>();

    public ObservableField<Long> getNumberOfFollowers() {
        return numberOfFollowers;
    }
    public ObservableField<Long> getNumberOfPosts() {
        return numberOfPosts;
    }
    public ObservableField<Long> getNumberOfFollowing() {
        return numberOfFollowing;
    }


    @BindingAdapter({"profileImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
      }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

    @Bindable
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
        notifyPropertyChanged(BR.about);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

}
