package com.example.thuyhien.signinapplication.dagger.module;

import com.example.thuyhien.signinapplication.network.endpoint.AuthenticateEndpoint;
import com.example.thuyhien.signinapplication.presenter.SignInPresenter;
import com.example.thuyhien.signinapplication.presenter.impl.SignInPresenterImpl;
import com.example.thuyhien.signinapplication.retrofit.AuthenticateInteractor;
import com.example.thuyhien.signinapplication.retrofit.impl.AuthenticateInteractorImpl;
import com.example.thuyhien.signinapplication.view.SignInView;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thuyhien on 11/13/17.
 */

@Module(includes = {AppModule.class, NetModule.class})
public class SignInModule {
    private SignInView signInView;

    public SignInModule(SignInView signInView) {
        this.signInView = signInView;
    }

    @Provides
    AuthenticateInteractor provideAuthenticateInteractor(AuthenticateEndpoint authenticateEndpoint,
                                                         Gson authenGson) {
        return new AuthenticateInteractorImpl(authenticateEndpoint, authenGson);
    }

    @Provides
    SignInPresenter provideSignInPresenter(AuthenticateInteractor authenticateInteractor) {
        return new SignInPresenterImpl(this.signInView, authenticateInteractor);
    }
}
