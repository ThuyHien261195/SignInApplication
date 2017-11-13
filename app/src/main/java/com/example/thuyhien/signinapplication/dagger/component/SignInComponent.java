package com.example.thuyhien.signinapplication.dagger.component;

import com.example.thuyhien.signinapplication.dagger.module.SignInModule;
import com.example.thuyhien.signinapplication.ui.SignInActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Subcomponent;

/**
 * Created by thuyhien on 11/13/17.
 */
@Singleton
@Subcomponent(modules = {SignInModule.class})
public interface SignInComponent {
    void inject(SignInActivity signInActivity);
}
