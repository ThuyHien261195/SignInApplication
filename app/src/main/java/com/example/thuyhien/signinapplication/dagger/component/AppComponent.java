package com.example.thuyhien.signinapplication.dagger.component;

import android.app.Application;

import com.example.thuyhien.signinapplication.dagger.module.AppModule;
import com.example.thuyhien.signinapplication.dagger.module.NetModule;
import com.example.thuyhien.signinapplication.dagger.module.SignInModule;

import dagger.Component;

/**
 * Created by thuyhien on 11/13/17.
 */


@Component (modules = {AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(Application application);

    SignInComponent createSignInComponent(SignInModule signInModule);
}
