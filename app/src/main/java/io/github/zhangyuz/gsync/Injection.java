package io.github.zhangyuz.gsync;

import android.content.Context;

import io.github.zhangyuz.gsync.data.source.GsyncDataSource;
import io.github.zhangyuz.gsync.data.source.GsyncDataRepository;
import io.github.zhangyuz.gsync.oauth.domain.usecases.AccessCodeTask;
import io.github.zhangyuz.gsync.oauth.domain.usecases.AuthCodeTask;

/**
 * Dependency injection.
 */
public class Injection {
    public static GsyncDataSource provideDataReporitory(Context context) {
        return new GsyncDataRepository(context);
    }

    public static UseCaseHandler provideUseCaseHandler() {
        return UseCaseHandler.getInstance();
    }

    public static AuthCodeTask provideAuthCodeTask(Context context) {
        return new AuthCodeTask(context, provideDataReporitory(context));
    }

    public static AccessCodeTask provideAccessCodeTask(Context context) {
        return new AccessCodeTask(context, provideDataReporitory(context));
    }
}
