package io.github.zhangyuz.gsync;

/**
 * Created by yuz on 17-4-12.
 */

public interface UseCaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.ResponseValues> void notifyResponse(final V response,
                                                           final UseCase.UseCaseCallback<V> callback);

    <V extends UseCase.ResponseValues> void onError(
            final UseCase.UseCaseCallback<V> callback);
}
