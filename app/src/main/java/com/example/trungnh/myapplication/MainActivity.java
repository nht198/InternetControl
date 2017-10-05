package com.example.trungnh.myapplication;

import android.app.Activity;
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

public class MainActivity extends Activity{

    private static final String URL = "http://tiensieunhan.xyz";
    Switch sw1_01,sw1_02,sw1_03,sw1_04,sw2_01,sw2_02,sw2_03,sw2_04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find ID
        sw1_01 = (Switch)findViewById(R.id.sw1_01);
        sw1_02 = (Switch)findViewById(R.id.sw1_02);
        sw1_03 = (Switch)findViewById(R.id.sw1_03);
        sw1_04 = (Switch)findViewById(R.id.sw1_04);
        sw2_01 = (Switch)findViewById(R.id.sw2_01);
        sw2_02 = (Switch)findViewById(R.id.sw2_02);
        sw2_03 = (Switch)findViewById(R.id.sw2_03);
        sw2_04 = (Switch)findViewById(R.id.sw2_04);
        initSwitch();
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
                boolean serverResponse = Boolean.valueOf(response.body().get(0).getStt1());
                sw1_01.setChecked(serverResponse);
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initSwitch()
    {
        CompoundButton.OnCheckedChangeListener multilisteListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                switch (v.getId()) {
                    case R.id.sw1_01:
                        Toast.makeText(getApplicationContext(),"button 1 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw1_02:
                        Toast.makeText(getApplicationContext(),"button 2 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw1_03:
                        Toast.makeText(getApplicationContext(),"button 3 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw1_04:
                        Toast.makeText(getApplicationContext(),"button 4 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.sw2_01:
                        Toast.makeText(getApplicationContext(),"button 1 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw2_02:
                        Toast.makeText(getApplicationContext(),"button 2 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw2_03:
                        Toast.makeText(getApplicationContext(),"button 3 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw2_04:
                        Toast.makeText(getApplicationContext(),"button 4 " + isChecked,Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        sw1_01.setOnCheckedChangeListener(multilisteListener);
        sw1_02.setOnCheckedChangeListener(multilisteListener);
        sw1_03.setOnCheckedChangeListener(multilisteListener);
        sw1_04.setOnCheckedChangeListener(multilisteListener);
        sw2_01.setOnCheckedChangeListener(multilisteListener);
        sw2_02.setOnCheckedChangeListener(multilisteListener);
        sw2_03.setOnCheckedChangeListener(multilisteListener);
        sw2_04.setOnCheckedChangeListener(multilisteListener);
    }
}
