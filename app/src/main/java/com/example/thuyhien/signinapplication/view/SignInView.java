package com.example.thuyhien.signinapplication.view;

/**
 * Created by thuyhien on 11/13/17.
 */

public interface SignInView {
    void onSignInSuccess();

    void showErrorMessage(Exception ex);
}
