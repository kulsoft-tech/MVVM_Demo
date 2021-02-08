package com.example.mmvmdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mmvmdemo.R;
import com.example.mmvmdemo.databinding.PostRowItemBinding;
import com.example.mmvmdemo.model.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {
    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener listener;


    public PostsAdapter(List<Post> postList, PostsAdapterListener listener) {
        this.postList = postList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        PostRowItemBinding postRowItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.post_row_item, parent, false);
        return new PostsViewHolder(postRowItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        holder.postRowItemBinding.setPost(postList.get(position));
        holder.postRowItemBinding.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onPostClicked(postList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {

        PostRowItemBinding postRowItemBinding;

        public PostsViewHolder(final PostRowItemBinding postRowItemBinding) {
            super(postRowItemBinding.getRoot());
            this.postRowItemBinding = postRowItemBinding;
        }
    }

    public interface PostsAdapterListener {
        void onPostClicked(Post post);
    }
}
