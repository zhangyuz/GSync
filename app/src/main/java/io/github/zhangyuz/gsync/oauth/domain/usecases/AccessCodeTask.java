package io.github.zhangyuz.gsync.oauth.domain.usecases;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.ClientAuthentication;
import net.openid.appauth.TokenRequest;
import net.openid.appauth.TokenResponse;

import io.github.zhangyuz.gsync.UseCase;
import io.github.zhangyuz.gsync.data.source.GsyncDataSource;

/**
 * Exchange auth code for access code.
 */
public class AccessCodeTask extends UseCase<AccessCodeTask.RequestValues,
        AccessCodeTask.ResponseValues> {

    private static final String TAG = "AccessCodeTask";

    GsyncDataSource mDataSource;
    AuthorizationService mAuthService;
    AuthState mAuthState;

    public AccessCodeTask(Context context, GsyncDataSource dataSource) {
        mDataSource = dataSource;
        mAuthService = new AuthorizationService(context);
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        performTokenRequest(requestValues.authState, requestValues.request);
    }

    private void performTokenRequest(AuthState state, TokenRequest request) {
        ClientAuthentication clientAuthentication;
        mAuthState = state;
        try {
            clientAuthentication = state.getClientAuthentication();
        } catch (ClientAuthentication.UnsupportedAuthenticationMethod ex) {
            Log.d(TAG, "Token request cannot be made, client authentication for the token "
                    + "endpoint could not be constructed (%s)", ex);
            return;
        }

        mAuthService.performTokenRequest(
                request,
                clientAuthentication,
                new AuthorizationService.TokenResponseCallback() {
                    @Override
                    public void onTokenRequestCompleted(
                            @Nullable TokenResponse tokenResponse,
                            @Nullable AuthorizationException ex) {
                        receivedTokenResponse(tokenResponse, ex);
                    }
                });
    }

    private void receivedTokenResponse(
            @Nullable TokenResponse tokenResponse,
            @Nullable AuthorizationException authException) {
        Log.d(TAG, "Token request complete");
        mAuthState.update(tokenResponse, authException);
        Log.i(TAG, "Received access token(" + mAuthState.getAccessToken() + ") refresh toke(" + mAuthState.getRefreshToken() + ")", authException);
        // Log.i(TAG, "Received auth state(" + mAuthState.jsonSerializeString() + ")");
        if (mAuthState.isAuthorized()) {
            getUseCaseCallback().onSuccess(new ResponseValues(mAuthState));
            mDataSource.saveAuthState(mAuthState.jsonSerializeString());
        } else {
            getUseCaseCallback().onError();
        }
        mAuthService.dispose();
    }

    public static class RequestValues implements UseCase.RequestValues {
        final AuthState authState;
        final TokenRequest request;

        public RequestValues(AuthState authState, TokenRequest request) {
            this.authState = authState;
            this.request = request;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValues {
        final AuthState state;

        public ResponseValues(AuthState state) {
            this.state = state;
        }
    }
}
