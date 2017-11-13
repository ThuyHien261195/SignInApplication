package com.example.thuyhien.signinapplication.utils;

import com.example.thuyhien.signinapplication.network.endpoint.AuthenticateEndpoint;
import com.example.thuyhien.signinapplication.network.exception.AuthenticationException;
import com.example.thuyhien.signinapplication.network.exception.UnknownException;
import com.example.thuyhien.signinapplication.network.model.AuthenticateError;
import com.google.gson.Gson;

import org.json.JSONObject;

import okhttp3.ResponseBody;

/**
 * Created by thuyhien on 11/13/17.
 */

public class RetrofitUtils {

    public static Exception createAuthenticateException(ResponseBody responseBody, Gson gson) {
        if (responseBody != null) {
            AuthenticateError authenticateError = gson.fromJson(responseBody.toString(), AuthenticateError.class);
            return new AuthenticationException(authenticateError.getMessage());
        } else {
            return new UnknownException();
        }
    }
}
