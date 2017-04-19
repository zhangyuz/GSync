package io.github.zhangyuz.gsync;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public final class GSyncApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
