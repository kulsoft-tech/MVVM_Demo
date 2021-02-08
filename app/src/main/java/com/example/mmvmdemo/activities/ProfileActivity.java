package com.example.mmvmdemo.activities;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.adapter.PostsAdapter;
import com.example.mmvmdemo.databinding.ActivityProfileScreenBinding;
import com.example.mmvmdemo.model.Post;
import com.example.mmvmdemo.model.User;
import com.example.mmvmdemo.utils.GridSpacingItemDecoration;
import com.example.mmvmdemo.utils.Handlers;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements PostsAdapter.PostsAdapterListener {


    Handlers handlers;
    User user;
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;


    ActivityProfileScreenBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile_screen);

        user = new User();
        handlers = new Handlers(this);

        renderProfile();
        inittiateRecycler();


    }

    private void inittiateRecycler() {
        recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        postsAdapter = new PostsAdapter(getPosts(), this);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(postsAdapter);
    }

    private void renderProfile() {

        user.setName("Shyam Lokhande");
        user.setEmail("Shyamlokhande91@gmail.com");
        user.setAbout("Android Developer");
       // user.setProfileImage("https://picsum.photos/200/300");

        user.numberOfFollowers.set(30L);
        user.numberOfFollowing.set(10L);
        user.numberOfPosts.set(10L);

        binding.setUser(user);
        binding.setHnadlers(handlers);
    }

    private ArrayList<Post> getPosts()
    {
        ArrayList<Post> posts = new ArrayList<>();
        for (int i=0; i<10; i++)
        {
            Post post = new Post();
            post.setImageUrl("https://picsum.photos/200/300");
            posts.add(post);
        }
    return posts;
    }

    @Override
    public void onPostClicked(Post post) {
        Toast.makeText(getApplicationContext(), "Post clicked! " + post.getImageUrl(), Toast.LENGTH_SHORT).show();

    }


    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
