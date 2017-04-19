package io.github.zhangyuz.gsync.oauth.domain.usecases;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationRequest;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.ResponseTypeValues;

import io.github.zhangyuz.gsync.UseCase;
import io.github.zhangyuz.gsync.data.source.GsyncDataSource;
import io.github.zhangyuz.gsync.oauth.OAuthActivity;
import io.github.zhangyuz.gsync.oauth.domain.model.IdentityProvider;

/**
 * Use case for getting access code.
 */
public class AuthCodeTask extends UseCase<AuthCodeTask.RequestValues, AuthCodeTask.ResponseValues> {
    final Context mContext;
    final GsyncDataSource mDataSource;

    public AuthCodeTask(Context context, GsyncDataSource dataSource) {
        mContext = context;
        mDataSource = dataSource;
    }

    private static PendingIntent createPostAuthorizationIntent(
            @NonNull Context context,
            @NonNull AuthorizationRequest request,
            @NonNull AuthState authState) {
        Intent intent = new Intent(context, OAuthActivity.class);
        intent.putExtra(OAuthActivity.EXTRA_AUTH_STATE, authState.jsonSerializeString());
        return PendingIntent.getActivity(context, request.hashCode(), intent, 0);
    }

    @Override
    public void executeUseCase(final RequestValues requestValues) {
        final IdentityProvider idp = requestValues.mIdentityProvider;
        AuthorizationService service = new AuthorizationService(mContext);
        AuthorizationServiceConfiguration config =
                new AuthorizationServiceConfiguration(requestValues.mIdentityProvider.getAuthEndpoint(),
                        requestValues.mIdentityProvider.getTokenEndpoint(), null);
        AuthorizationRequest request = new AuthorizationRequest.Builder(config, idp.getClientId(),
                ResponseTypeValues.CODE, idp.getRedirectUri())
                .setScope(idp.getScope())
                .build();
        AuthState state = new AuthState();
        service.performAuthorizationRequest(request,
                createPostAuthorizationIntent(
                        mContext,
                        request,
                        state));
        service.dispose();
        getUseCaseCallback().onSuccess(null);
    }

    public static class RequestValues implements UseCase.RequestValues {
        private final IdentityProvider mIdentityProvider;

        public RequestValues(IdentityProvider identityProvider) {
            mIdentityProvider = identityProvider;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValues {
        AuthState mAuthState;
    }
}
