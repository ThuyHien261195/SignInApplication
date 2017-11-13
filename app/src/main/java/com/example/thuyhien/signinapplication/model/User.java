package com.example.thuyhien.signinapplication.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by thuyhien on 11/13/17.
 */

public class User {
    private String token;

    @SerializedName("refresh_token")
    private String refreshToken;

    public User(String token, String requestToken) {
        this.token = token;
        refreshToken = requestToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
