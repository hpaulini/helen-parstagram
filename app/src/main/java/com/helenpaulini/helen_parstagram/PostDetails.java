package com.helenpaulini.helen_parstagram;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class PostDetails extends AppCompatActivity {

    Post post;

    private TextView tvUser;
    private TextView tvCaption;
    private ImageView ivPic;
    private TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_details);
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));

        Log.i("PostDetails", "Showing details for post");

        tvUser = (TextView) findViewById(R.id.tvUser);
        tvCaption = (TextView) findViewById(R.id.tvCaption);
        ivPic = (ImageView) findViewById(R.id.ivPic);
        tvDate = (TextView) findViewById(R.id.tvDate);

        tvUser.setText(post.getUser().getUsername());
        tvCaption.setText(post.getDescription());
        String date = post.getCreatedAt().toString();
        tvDate.setText(date);
        ParseFile image = post.getImage();
        if (image != null) {
            Glide.with(this).load(image.getUrl()).into(ivPic);
        }
    }
}
