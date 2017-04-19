package io.github.zhangyuz.gsync;

import android.os.Handler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class UseCaseThreadPoolScheduler implements UseCaseScheduler {
    private static final int POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private static final int MAX_POOL_SIZE = POOL_SIZE * 2;
    private static final int TIME_OUT = 60;

    private final Handler mHandler = new Handler();

    ThreadPoolExecutor mThreadPoolExecutor;

    public UseCaseThreadPoolScheduler() {
        mThreadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE,
                TIME_OUT, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(POOL_SIZE));
    }

    @Override
    public void execute(Runnable runnable) {
        mThreadPoolExecutor.execute(runnable);
    }

    @Override
    public <V extends UseCase.ResponseValues> void notifyResponse(final V response,
            final UseCase.UseCaseCallback<V> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onSuccess(response);
            }
        });
    }

    @Override
    public <V extends UseCase.ResponseValues> void onError(
            final UseCase.UseCaseCallback<V> callback) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                callback.onError();
            }
        });
    }
}
