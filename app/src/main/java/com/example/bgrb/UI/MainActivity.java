package com.example.bgrb.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;

import com.example.bgrb.Adapters.PostAdapter;
import com.example.bgrb.Models.PostModel;
import com.example.bgrb.R;
import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.button), "This is a Button", "We have the best targets, believe me")
                        .tintTarget(false)
                        .titleTextSize(25)
                        .descriptionTextSize(10)
                        .textTypeface(Typeface.SANS_SERIF)
                        .drawShadow(true)
                        .cancelable(false)
        );

                postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPost();

        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostAdapter postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        postViewModel.modelMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setList(postModels);
            }
        });
    }
}
