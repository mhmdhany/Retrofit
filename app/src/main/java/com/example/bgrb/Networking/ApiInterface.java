package com.example.bgrb.Networking;

import com.example.bgrb.Models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<PostModel>> getPosts();
}
