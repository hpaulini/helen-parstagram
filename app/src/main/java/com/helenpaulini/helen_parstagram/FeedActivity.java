package com.helenpaulini.helen_parstagram;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    private RecyclerView rvFeed;
    protected PostsAdapter postsAdapter;
    protected List<Post> postList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        rvFeed = findViewById(R.id.rvFeed);

        postList = new ArrayList<>();
        postsAdapter = new PostsAdapter(this, postList);
    }
}
