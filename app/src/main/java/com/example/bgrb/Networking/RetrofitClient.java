package com.example.bgrb.Networking;

import com.example.bgrb.Models.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private static RetrofitClient INSTANCE;
    private ApiInterface postInterface;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(ApiInterface.class);
    }
        public static RetrofitClient getINSTANCE(){
            if (INSTANCE == null){
                INSTANCE = new RetrofitClient();
            }
            return INSTANCE;
        }
    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }

}
