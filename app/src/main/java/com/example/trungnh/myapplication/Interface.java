package com.example.trungnh.myapplication;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by trungnh on 10/5/17.
 */

public interface Interface {
    //This method is used for "GET"
    @GET("database.php")
    Call<List<ServerResponse>> getServerResponse(@Query("id") String idDevice);

    //This method is used for "POST"
    @POST("database.php")
    Call<ResponseBody> postCall(@Field("id") String id,
                        @Field("stt") String stt,
                        @Field("value") int value);
}
