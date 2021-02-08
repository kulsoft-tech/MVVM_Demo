package com.example.mmvmdemo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.adapter.PlacesAdapter;
import com.example.mmvmdemo.model.MyPlaces;
import com.example.mmvmdemo.viewmodel.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    RecyclerView recyclerView;
    FloatingActionButton fab;
    ProgressBar progress;
    PlacesAdapter placesAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = findViewById(R.id.progress);
        fab = findViewById(R.id.fabAdd);
        recyclerView = findViewById(R.id.recycler);


        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.init();
        mainActivityViewModel.getMyPlaces().observe(this, new Observer<List<MyPlaces>>() {
            @Override
            public void onChanged(List<MyPlaces> myPlaces) {
                placesAdapter.notifyDataSetChanged();
            }
        });


        mainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    progress.setVisibility(View.VISIBLE);
                } else {
                    progress.setVisibility(View.GONE);

                    recyclerView.smoothScrollToPosition(mainActivityViewModel.getMyPlaces().getValue().size() - 1);
                }
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivityViewModel.addPlaces(new MyPlaces("Satara", ""));
            }
        });

        initRecyclerView();


    }

    private void initRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        placesAdapter = new PlacesAdapter(this, mainActivityViewModel.getMyPlaces().getValue());
        recyclerView.setAdapter(placesAdapter);
    }
}
