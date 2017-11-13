package com.example.thuyhien.signinapplication;

import android.app.Application;

import com.example.thuyhien.signinapplication.dagger.component.AppComponent;
import com.example.thuyhien.signinapplication.dagger.component.DaggerAppComponent;
import com.example.thuyhien.signinapplication.dagger.module.AppModule;
import com.example.thuyhien.signinapplication.dagger.module.NetModule;

import javax.inject.Inject;

/**
 * Created by thuyhien on 11/13/17.
 */

public class SignInApplication extends Application {
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public SignInApplication() {
        this.appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        this.appComponent.inject(this);
    }
}
