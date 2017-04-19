package io.github.zhangyuz.gsync;

public class UseCaseHandler {
    private static UseCaseHandler INSTANCE;

    private UseCaseScheduler mUseCaseScheduler;

    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            synchronized (UseCaseHandler.class) {
                if (INSTANCE == null) {
                    INSTANCE = new UseCaseHandler(new UseCaseThreadPoolScheduler());
                }
            }
        }
        return INSTANCE;
    }

    public UseCaseHandler(UseCaseScheduler scheduler) {
        mUseCaseScheduler = scheduler;
    }

    public <Q extends UseCase.RequestValues, P extends UseCase.ResponseValues> void execute(
            final UseCase<Q, P> useCase, final Q requestValues,
            final UseCase.UseCaseCallback<P> callback) {
        useCase.setRequestValues(requestValues);
        useCase.setUseCaseCallback(new CallbackWrapper(callback, this));

        mUseCaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                useCase.run();
            }
        });
    }

    public <P extends UseCase.ResponseValues> void notifyResponse(final P responseValues,
                                                                  final UseCase.UseCaseCallback<P> callback) {
        mUseCaseScheduler.notifyResponse(responseValues, callback);
    }

    public <P extends UseCase.ResponseValues> void notifyError(UseCase.UseCaseCallback<P> callback) {
        mUseCaseScheduler.onError(callback);
    }

    private static final class CallbackWrapper<P extends UseCase.ResponseValues> implements UseCase.UseCaseCallback<P> {
        private final UseCase.UseCaseCallback<P> mUseCaseCallback;
        private final UseCaseHandler mUseCaseHandler;

        public CallbackWrapper(UseCase.UseCaseCallback<P> useCaseCallback,
                               UseCaseHandler useCaseHandler) {
            mUseCaseCallback = useCaseCallback;
            mUseCaseHandler = useCaseHandler;
        }

        @Override
        public void onSuccess(P response) {
            mUseCaseHandler.notifyResponse(response, mUseCaseCallback);
        }

        @Override
        public void onError() {
            mUseCaseHandler.notifyError(mUseCaseCallback);
        }
    }
}
