package com.example.trungnh.myapplication;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import br.com.goncalves.pugnotification.notification.PugNotification;
import me.leolin.shortcutbadger.ShortcutBadger;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends Activity implements OnMapReadyCallback{

    private static final String URL = "http://tiensieunhan.xyz";
    Switch sw1_01,sw1_02,sw1_03,sw1_04,sw2_01,sw2_02,sw2_03,sw2_04;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find ID
        progressBar = findViewById(R.id.prsBar);
        sw1_01 = (Switch)findViewById(R.id.sw1_01);
        sw1_02 = (Switch)findViewById(R.id.sw1_02);
        sw1_03 = (Switch)findViewById(R.id.sw1_03);
        sw1_04 = (Switch)findViewById(R.id.sw1_04);
        sw2_01 = (Switch)findViewById(R.id.sw2_01);
        sw2_02 = (Switch)findViewById(R.id.sw2_02);
        sw2_03 = (Switch)findViewById(R.id.sw2_03);
        sw2_04 = (Switch)findViewById(R.id.sw2_04);

        //Begin
        progressBar.setVisibility(View.VISIBLE);
        initMap();
        getData(); //Get initial data

        PugNotification.with(getApplicationContext())
                .load()
                .title("Internet control")
                .message("Hello")
                .bigTextStyle("Hello world")
                .smallIcon(R.drawable.pugnotification_ic_launcher)
                .largeIcon(R.drawable.pugnotification_ic_launcher)
                .flags(Notification.DEFAULT_LIGHTS)
                .simple()
                .build();
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
                //Set for id 1
                int stt1 = Integer.parseInt(response.body().get(0).getStt1());
                int stt2 = Integer.parseInt(response.body().get(0).getStt2());
                int stt3 = Integer.parseInt(response.body().get(0).getStt3());
                int stt4 = Integer.parseInt(response.body().get(0).getStt4());
                //Set initial
                sw1_01.setOnCheckedChangeListener(null);
                sw1_01.setChecked((stt1==1?true:false));
                sw1_02.setChecked((stt2==1?true:false));
                sw1_03.setChecked((stt3==1?true:false));
                sw1_04.setChecked((stt4==1?true:false));


                //Set for id 2
                stt1 = Integer.parseInt(response.body().get(1).getStt1());
                stt2 = Integer.parseInt(response.body().get(1).getStt2());
                stt3 = Integer.parseInt(response.body().get(1).getStt3());
                stt4 = Integer.parseInt(response.body().get(1).getStt4());
                //Set initial
                sw2_01.setChecked((stt1==1?true:false));
                sw2_02.setChecked((stt2==1?true:false));
                sw2_03.setChecked((stt3==1?true:false));
                sw2_04.setChecked((stt4==1?true:false));
                progressBar.setVisibility(View.INVISIBLE);
                initSwitch();
            }

            @Override
            public void onFailure(Call<List<ServerResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"error", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    public void postData(String id,String stt,int value)
    {
        //The Retrofit builder will have the client attached, in order to get connection logs
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(URL)
                .build();

        Interface service = retrofit.create(Interface.class);
        Call<ResponseBody> call = service.postCall(id,stt,value);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

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
                        postData("R0001","stt1",0);
//                        Toast.makeText(MainActivity.this,"stt1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sw1_02:
//                        postData("R0001","stt1",1);
                        break;
                    case R.id.sw1_03:
//                        postData("R0001","stt1",1);
                        break;
                    case R.id.sw1_04:
//                        postData("R0001","stt1",1);
                        break;

                    case R.id.sw2_01:
//                        postData("R0001","stt1",1);
                        break;
                    case R.id.sw2_02:
//                        postData("R0001","stt1",1);
                        break;
                    case R.id.sw2_03:
//                        postData("R0001","stt1",1);
                        break;
                    case R.id.sw2_04:
//                        postData("R0001","stt1",1);
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

    public void offListener()
    {
        sw1_01.setOnCheckedChangeListener(null);
        sw1_02.setOnCheckedChangeListener(null);
        sw1_03.setOnCheckedChangeListener(null);
        sw1_04.setOnCheckedChangeListener(null);
        sw2_01.setOnCheckedChangeListener(null);
        sw2_02.setOnCheckedChangeListener(null);
        sw2_03.setOnCheckedChangeListener(null);
        sw2_04.setOnCheckedChangeListener(null);
    }

    public void initMap()
    {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fgMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng latLng = new LatLng(10.8537915,106.6261557);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,17.0f));
        googleMap.addMarker(new MarkerOptions().position(latLng).title("cvpm"));
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }
}
