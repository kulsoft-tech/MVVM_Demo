package com.example.mmvmdemo.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.mmvmdemo.model.MyPlaces;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MyPlaceRepositories {

    private static MyPlaceRepositories myPlaceRepositories;
    private ArrayList<MyPlaces> dataSet = new ArrayList<>();



    // Singleton Pattern
    public static MyPlaceRepositories getInstance(){
        if(myPlaceRepositories == null) {
            myPlaceRepositories = new MyPlaceRepositories();
        }
        return myPlaceRepositories;
    }

    // pretend to get data from Online Service or webservice
    public MutableLiveData<List<MyPlaces>> getMyPlaces() {

        setMyPlaces();
        MutableLiveData<List<MyPlaces>> mPlaces = new MutableLiveData<>();
        mPlaces.setValue(dataSet);
        return mPlaces;
    }

    private void setMyPlaces() {
        dataSet.add(new MyPlaces("Mumbai",""));
        dataSet.add(new MyPlaces("Pune",""));
        dataSet.add(new MyPlaces("Ahmednagar",""));
        dataSet.add(new MyPlaces("Nashik",""));
        dataSet.add(new MyPlaces("Dhule",""));

    }
}
