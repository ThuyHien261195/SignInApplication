package com.example.thuyhien.signinapplication.retrofit.impl;

import com.example.thuyhien.signinapplication.model.User;
import com.example.thuyhien.signinapplication.network.endpoint.AuthenticateEndpoint;
import com.example.thuyhien.signinapplication.network.listener.AuthenticateListener;
import com.example.thuyhien.signinapplication.network.model.SignInRequest;
import com.example.thuyhien.signinapplication.retrofit.AuthenticateInteractor;
import com.example.thuyhien.signinapplication.utils.RetrofitUtils;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thuyhien on 11/13/17.
 */

public class AuthenticateInteractorImpl implements AuthenticateInteractor {
    private static final String AUTHEN_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwcm9qZWN0X2lkIjoiNTg2NWU1YTdmYmE5NWU4MmE4ODA3MmJkIiwiaWF0IjoxNDY5NzkxMDc4fQ.Sv1PG7ZFooqSufUyGQHEbYRqYSVMRIANkV36HVBjVvQ";

    private AuthenticateEndpoint authenticateEndpoint;
    private Gson authenGson;

    public AuthenticateInteractorImpl(AuthenticateEndpoint authenticateEndpoint, Gson authenGson) {
        this.authenticateEndpoint = authenticateEndpoint;
        this.authenGson = authenGson;
    }

    @Override
    public void signIn(SignInRequest signInRequest, final AuthenticateListener listener) {
        Call<User> signIn = authenticateEndpoint.signIn(AUTHEN_TOKEN, signInRequest);
        signIn.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    listener.onAuthenticateSuccess(response.body());
                } else {
                    listener.onAuthenticateFail(RetrofitUtils.createAuthenticateException(response.errorBody(), authenGson));
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onAuthenticateFail(new Exception(t));
            }
        });
    }
}
