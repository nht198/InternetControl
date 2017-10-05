package com.example.trungnh.myapplication;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnh on 10/5/17.
 */

public class ServerResponse {
    private String id;
    private int stt1;
    private int stt2;
    private int stt3;
    private int stt4;

    public ServerResponse(String id, int stt1, int stt2, int stt3, int stt4) {
        this.id = id;
        this.stt1 = stt1;
        this.stt2 = stt2;
        this.stt3 = stt3;
        this.stt4 = stt4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStt1() {
        return stt1;
    }

    public void setStt1(int stt1) {
        this.stt1 = stt1;
    }

    public int getStt2() {
        return stt2;
    }

    public void setStt2(int stt2) {
        this.stt2 = stt2;
    }

    public int getStt3() {
        return stt3;
    }

    public void setStt3(int stt3) {
        this.stt3 = stt3;
    }

    public int getStt4() {
        return stt4;
    }

    public void setStt4(int stt4) {
        this.stt4 = stt4;
    }
}
