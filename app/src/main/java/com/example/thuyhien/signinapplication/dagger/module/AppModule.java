package com.example.thuyhien.signinapplication.dagger.module;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thuyhien on 11/13/17.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Gson provideUserGson() {
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }
}
