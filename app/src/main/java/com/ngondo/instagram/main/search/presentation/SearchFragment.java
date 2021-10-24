package com.ngondo.instagram.main.search.presentation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ngondo.instagram.R;

public class SearchFragment extends Fragment {

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_main_search, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.search_recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(new PostAdapter());

        return view;
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imagePost;

        public PostViewHolder(@NonNull View itewView) {
            super(itewView);
            imagePost = itemView.findViewById(R.id.main_search_imageview_user);
        }

        public void bind(int image) {
            this.imagePost.setImageResource(image);
        }
    }

    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

        private final int[] images = new int[] {
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add,
                R.drawable.ic_insta_add
        };

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PostViewHolder(getLayoutInflater().inflate(R.layout.item_user_list, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull SearchFragment.PostViewHolder holder, int position) {
            holder.bind(images[position]);
        }

        @Override
        public int getItemCount() {
            return images.length;
        }
    }

    }

