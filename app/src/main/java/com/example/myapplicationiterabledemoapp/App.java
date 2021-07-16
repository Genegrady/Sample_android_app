package com.example.myapplicationiterabledemoapp;

import android.app.Application;

import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableConfig;
import com.iterable.iterableapi.IterableInAppHandler;
import com.iterable.iterableapi.IterableInAppMessage;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        class MyInAppHandler implements IterableInAppHandler {
            @Override
            public InAppResponse onNewInApp(IterableInAppMessage message) {
                if (true) {
                    return InAppResponse.SHOW;
                } else {
                    return InAppResponse.SKIP;
                }
            }
        }

        IterableConfig config = new IterableConfig.Builder().setPushIntegrationName("myPushIntegration")
                .setInAppHandler(new MyInAppHandler())
                .build();;
        IterableApi.initialize(getApplicationContext(), "api_key", config);
    }
}
