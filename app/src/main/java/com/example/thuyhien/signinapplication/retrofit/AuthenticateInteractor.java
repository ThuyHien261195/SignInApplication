package com.example.thuyhien.signinapplication.retrofit;

import com.example.thuyhien.signinapplication.network.listener.AuthenticateListener;
import com.example.thuyhien.signinapplication.network.model.SignInRequest;

/**
 * Created by thuyhien on 11/13/17.
 */

public interface AuthenticateInteractor {
    void signIn(SignInRequest signInRequest, AuthenticateListener listener);
}
