package io.github.zhangyuz.gsync;

public abstract class UseCase<Q extends UseCase.RequestValues,
        P extends UseCase.ResponseValues> {

    private Q mRequestValues;

    private UseCaseCallback<P> mUseCaseCallback;

    public Q getRequestValues() {
        return mRequestValues;
    }

    public void setRequestValues(Q requestValues) {
        mRequestValues = requestValues;
    }

    public UseCaseCallback<P> getUseCaseCallback() {
        return mUseCaseCallback;
    }

    public void setUseCaseCallback(UseCaseCallback<P> useCaseCallback) {
        mUseCaseCallback = useCaseCallback;
    }

    public void run() {
        executeUseCase(mRequestValues);
    }

    protected abstract void executeUseCase(Q requestValues);

    public interface RequestValues {
    }

    public interface ResponseValues {
    }

    public interface UseCaseCallback<R> {
        void onSuccess(R response);

        void onError();
    }
}
