package com.example.mmvmdemo.viewmodel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mmvmdemo.model.MyPlaces;
import com.example.mmvmdemo.repositories.MyPlaceRepositories;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<MyPlaces>> mPlaces;

    private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

    private MyPlaceRepositories myPlaceRepositories;

    public void init(){
        if(mPlaces!=null) {
            return;
        }

        myPlaceRepositories = MyPlaceRepositories.getInstance();
        mPlaces = myPlaceRepositories.getMyPlaces();
    }

    public LiveData<List<MyPlaces>> getMyPlaces() {
     return mPlaces;
    }

    public void addPlaces(MyPlaces myPlaces) {
        isUpdating.setValue(true);
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                List<MyPlaces>  currentplace = mPlaces.getValue();
                currentplace.add(myPlaces);
                mPlaces.setValue(currentplace);
                isUpdating.postValue(false);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<Boolean> getIsUpdating() {
        return isUpdating;
    }
}
