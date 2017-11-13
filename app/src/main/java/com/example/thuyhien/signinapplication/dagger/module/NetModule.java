package com.example.thuyhien.signinapplication.dagger.module;

import com.example.thuyhien.signinapplication.network.endpoint.AuthenticateEndpoint;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by thuyhien on 11/13/17.
 */

@Module
public class NetModule {
    private static final String BASE_AUTHEN_URL = "http://userkit-identity-stg.ap-southeast-1.elasticbeanstalk.com/";

    @Provides
    @Singleton
    static AuthenticateEndpoint provideAuthenticateEndpoint(Retrofit retrofit) {
        return retrofit.create(AuthenticateEndpoint.class);
    }

    @Provides
    @Singleton
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_AUTHEN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
