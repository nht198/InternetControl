package com.example.trungnh.myapplication;


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

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        Interface service = retrofit.create(Interface.class);
        Call<List<ServerResponse>> call = service.getServerResponse("E0001");
        call.enqueue(new Callback<List<ServerResponse>>() {
            @Override
            public void onResponse(Call<List<ServerResponse>> call, Response<List<ServerResponse>> response) {

                String serverResponse = response.body().get(0).getStt1();
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {

            }
        });
    }
}
