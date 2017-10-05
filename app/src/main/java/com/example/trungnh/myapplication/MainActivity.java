package com.example.trungnh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String URL = "https://tiensieunhan.xyz";
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

    public void getData()
    {
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        Interface service = retrofit.create(Interface.class);
        Call<List<ServerResponse>> call = service.getServerResponse("E0001");
        call.enqueue(new Callback<List<ServerResponse>>() {
            @Override
            public void onResponse(Call<List<ServerResponse>> call, Response<List<ServerResponse>> response) {
                ServerResponse serverResponse = (ServerResponse) response.body();
                Toast.makeText(MainActivity.this, "sucess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
