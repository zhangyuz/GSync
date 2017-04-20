package io.github.zhangyuz.gsync.oauth;

import android.util.Log;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

import io.github.zhangyuz.gsync.BuildConfig;
import io.github.zhangyuz.gsync.UseCase;
import io.github.zhangyuz.gsync.UseCaseHandler;
import io.github.zhangyuz.gsync.oauth.domain.model.IdentityProvider;
import io.github.zhangyuz.gsync.oauth.domain.usecases.AccessCodeTask;
import io.github.zhangyuz.gsync.oauth.domain.usecases.AuthCodeTask;


public final class OAuthPresenter implements OAuthContract.Presenter {

    private static final String TAG = "OAuthPresenter";
    private final UseCaseHandler mUseCaseHandler;
    private AuthState mAuthState;
    private OAuthContract.View mView;
    private AuthCodeTask mAuthCodeTask;
    private AccessCodeTask mAccessCodeTask;

    public OAuthPresenter(OAuthContract.View view, AuthCodeTask authCodeTask,
                          AccessCodeTask accessCodeTask, UseCaseHandler useCaseHandler) {
        mView = view;
        mAuthCodeTask = authCodeTask;
        mAccessCodeTask = accessCodeTask;
        mUseCaseHandler = useCaseHandler;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        // Start OAuth here.
        Log.d(TAG, "start()");
        startAuthentication();
    }

    @Override
    public void startAuthentication() {
        mView.showAuthenticatingUi();

        IdentityProvider idp = new IdentityProvider("Google",
                true, null, "https://accounts.google.com/o/oauth2/v2/auth",
                "https://www.googleapis.com/oauth2/v4/token",
                null, BuildConfig.clientId, BuildConfig.redirectUri,
                "openid profile email https://www.google.com/m8/feeds/ ");
        AuthCodeTask.RequestValues requestValues = new AuthCodeTask.RequestValues(idp);
        mUseCaseHandler.execute(mAuthCodeTask, requestValues, new UseCase.UseCaseCallback<AuthCodeTask.ResponseValues>() {
            @Override
            public void onSuccess(AuthCodeTask.ResponseValues response) {
                // Means nothing, cause the task can not get the result
            }

            @Override
            public void onError() {
                // Means nothing, cause the task can not get the result
            }
        });
    }

    @Override
    public void authenticationFinished(AuthState authState, AuthorizationResponse response,
                                       AuthorizationException e) {
        if (authState != null) {
            mAuthState = authState;
            authState.update(response, e);
            if (response != null) {
                exchangeAuthForAccessCode(response);
            } else {
                mView.showAuthenticationResult(false);
                Log.w(TAG, "empty response of auth request");
            }
        }
    }

    @Override
    public void exchangeAuthForAccessCode(AuthorizationResponse response) {
        mView.showExchangingUi();
        AccessCodeTask.RequestValues requestValues = new AccessCodeTask.RequestValues(mAuthState,
                response.createTokenExchangeRequest());
        mUseCaseHandler.execute(mAccessCodeTask, requestValues, new UseCase.UseCaseCallback<AccessCodeTask.ResponseValues>() {
            @Override
            public void onSuccess(AccessCodeTask.ResponseValues response) {
                Log.d(TAG, "Exchange OK");
                mView.showExchangingResult(true);
            }

            @Override
            public void onError() {
                Log.d(TAG, "Exchange ERROR");
                mView.showExchangingResult(false);
            }
        });
    }

    @Override
    public void refreshAccessCode(AuthState state) {
        mView.showExchangingUi();
        AccessCodeTask.RequestValues requestValues = new AccessCodeTask.RequestValues(mAuthState,
                state.createTokenRefreshRequest());
        mUseCaseHandler.execute(mAccessCodeTask, requestValues, new UseCase.UseCaseCallback<AccessCodeTask.ResponseValues>() {
            @Override
            public void onSuccess(AccessCodeTask.ResponseValues response) {
                Log.d(TAG, "Refresh OK");
                mView.showExchangingResult(true);
            }

            @Override
            public void onError() {
                Log.d(TAG, "Refresh ERROR");
                mView.showExchangingResult(false);
            }
        });
    }

}
