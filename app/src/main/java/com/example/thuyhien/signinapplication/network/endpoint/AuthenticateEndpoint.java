package com.example.thuyhien.signinapplication.network.endpoint;

import com.example.thuyhien.signinapplication.model.User;
import com.example.thuyhien.signinapplication.network.model.SignInRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by thuyhien on 11/13/17.
 */

public interface AuthenticateEndpoint {

    @POST("v1/auth/signin")
    Call<User> signIn(@Header("X-USERKIT-TOKEN") String token, @Body SignInRequest signInRequest);
}
