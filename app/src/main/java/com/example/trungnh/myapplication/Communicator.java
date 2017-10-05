package com.example.trungnh.myapplication;


import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trungnh on 10/5/17.
 */

public class Communicator {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "https://tiensieunhan.xyz";
    private static Retrofit retrofit = null;

    public void getData()
    {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                                    .baseUrl(URL)
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
        }
    }
}
