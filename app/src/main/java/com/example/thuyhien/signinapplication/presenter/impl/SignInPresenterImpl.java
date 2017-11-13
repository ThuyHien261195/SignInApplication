package com.example.thuyhien.signinapplication.presenter.impl;

import com.example.thuyhien.signinapplication.R;
import com.example.thuyhien.signinapplication.exception.GeneralException;
import com.example.thuyhien.signinapplication.model.User;
import com.example.thuyhien.signinapplication.network.listener.AuthenticateListener;
import com.example.thuyhien.signinapplication.network.model.SignInRequest;
import com.example.thuyhien.signinapplication.presenter.SignInPresenter;
import com.example.thuyhien.signinapplication.retrofit.AuthenticateInteractor;
import com.example.thuyhien.signinapplication.utils.AuthenticationUtils;
import com.example.thuyhien.signinapplication.view.SignInView;

import java.lang.ref.WeakReference;

/**
 * Created by thuyhien on 11/13/17.
 */

public class SignInPresenterImpl implements SignInPresenter {

    private WeakReference<SignInView> signInViewWeakRef;
    private AuthenticateInteractor authenticateInteractor;

    public SignInPresenterImpl(SignInView signInView, AuthenticateInteractor authenticateInteractor) {
        this.signInViewWeakRef = new WeakReference<SignInView>(signInView);
        this.authenticateInteractor = authenticateInteractor;
    }

    @Override
    public void signIn(String email, String password) {
        boolean validEmail = AuthenticationUtils.checkValidEmail(email);
        boolean validPassword = AuthenticationUtils.checkValidPassword(password);

        if (!validEmail || !validPassword) {
            if (getSignInView() != null) {
                getSignInView().showErrorMessage(new GeneralException(R.string.invalid_input));
            }
        } else {
            SignInRequest signInRequest = new SignInRequest(email, password);
            authenticateInteractor.signIn(signInRequest, new AuthenticateListener() {
                @Override
                public void onAuthenticateSuccess(User data) {
                    if(getSignInView() != null) {
                        getSignInView().onSignInSuccess();
                    }
                }

                @Override
                public void onAuthenticateFail(Exception ex) {
                    if (getSignInView() != null) {
                        getSignInView().showErrorMessage(ex);
                    }
                }
            });
        }

    }

    private SignInView getSignInView() {
        return signInViewWeakRef.get();
    }
}
