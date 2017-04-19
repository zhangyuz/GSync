package io.github.zhangyuz.gsync.oauth;

import net.openid.appauth.AuthState;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

import io.github.zhangyuz.gsync.BasePresenter;
import io.github.zhangyuz.gsync.BaseView;

public interface OAuthContract {
    interface View extends BaseView<Presenter> {
        void showAuthenticatingUi();
        void showAuthenticationResult(boolean success);
        void showExchangingUi();
        void showExchangingResult(boolean success);
    }

    interface Presenter extends BasePresenter {
        void startAuthentication();
        void authenticationFinished(AuthState authState, AuthorizationResponse response,
                                       AuthorizationException e);
        void exchangeAuthForAccessCode(AuthorizationResponse response);
        void refreshAccessCode(AuthState state);
    }
}
