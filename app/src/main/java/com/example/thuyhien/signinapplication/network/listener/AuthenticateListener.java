package com.example.thuyhien.signinapplication.network.listener;

import com.example.thuyhien.signinapplication.model.User;

/**
 * Created by thuyhien on 11/13/17.
 */

public interface AuthenticateListener {
    void onAuthenticateSuccess(User data);

    void onAuthenticateFail(Exception ex);
}
