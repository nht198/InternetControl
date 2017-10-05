package com.example.trungnh.myapplication;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    private static final String URL = "http://tiensieunhan.xyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }

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
                Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        CompoundButton.OnCheckedChangeListener multilisteListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                switch (v.getId()) {
                    case R.id.sw1_01:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw1_02:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw1_03:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw1_04:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.sw2_01:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw2_02:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw2_03:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sw2_04:
                        Toast.makeText(getApplicationContext(),"button 1",Toast.LENGTH_LONG).show();
                        break;

                }
            }
        };
        ((Switch)findViewById(R.id.sw1_01)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw1_02)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw1_03)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw1_04)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw2_01)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw2_02)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw2_03)).setOnCheckedChangeListener(multilisteListener);
        ((Switch)findViewById(R.id.sw2_04)).setOnCheckedChangeListener(multilisteListener);
    }
}
