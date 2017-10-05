package com.example.trungnh.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnh on 10/5/17.
 */

public class ServerResponse {
    private String id;
    private String stt1;
    private String stt2;
    private String stt3;
    private String stt4;

    public ServerResponse(String id, String stt1, String stt2, String stt3, String stt4) {
        this.id = id;
        this.stt1 = stt1;
        this.stt2 = stt2;
        this.stt3 = stt3;
        this.stt4 = stt4;
    }

    public String getId() {
        return id;
    }

    public String getStt1() {
        return stt1;
    }

    public String getStt2() {
        return stt2;
    }

    public String getStt3() {
        return stt3;
    }

    public String getStt4() {
        return stt4;
    }
}
